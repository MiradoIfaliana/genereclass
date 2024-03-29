package connect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import connect.GenereClass;
import connect.GenereController;
import connect.GenereView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class GenereProject {

    //---server
    String http;
    String host;
    String port;
    //---json variable
    String pathjsonAng;
    String pathjsonClass;
    String pathjsonController;

    //---template 
    //view
    String pathtemplatehtml;
    String pathtemplateComponentTs;
    String pathtemplateComponentSpecTs;
    String pathtemplatecompocss;

    String pathtemplAppComponentHtml;
    String pathtemplAppRoutesTs;
    String pathtemplAppComponentTs;
    //controller
    String pathtemplatecontroller;
    String pathtemplateclass;
 
    //path
    String pathproject;
    //database name
    String databasename;
    String dbhost;
    String dbport;
    String dbusername;
    String dbpassword;
    //---sans config xml
    String nameproject;
    String languagebackend;//java--->back : spring & extension: java  || csharp--->back : dotnet & extension: cs ->choix par java ou csharp
    String extension; //efa antin'le variable json
    String typecontroller;
    int choixgenerer; //1:class seulement \n 2:controller seulement\n 3:class et controller\n 4:projet"

    boolean genereview;
    String languageview;//choix iray : angular

    String tablename; //----> "<nom du table>" ou "*" pour tous
    
   //package //hafa ny fanaovana azy @ c# sy @ java
    String packageclassmodel;
    String packagecontroller;



    //------------------------


    public GenereProject() {}
    public Element getRootElement(String pathconfigxml)throws Exception{
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        File xmlFile = new File(pathconfigxml);
        Document document = builder.parse(xmlFile);
        Element rootElement= document.getDocumentElement();
        return rootElement;
    }
    public String getContentXml(Element rootElement,String pathconfigxml,String tagnamesbypointvirgule,String indexitempointvirgule )throws Exception{
        String[] tagnames= tagnamesbypointvirgule.split(";");
        String[] indexitems=indexitempointvirgule.split(";");
          //----------------------------------------------------------------------------------recuperation des class annoter scope
          NodeList nodetemp=null;
          Element eltemp=rootElement;
          String conttemp=null;
          if(tagnames.length!=indexitems.length){ throw new Exception("nombre des tagnames ne correspond pas aux indexitems ("+tagnames.length+" et "+indexitems.length+")"); }
          for(int i=0;i<tagnames.length;i++){
            eltemp=(Element)eltemp.getElementsByTagName(tagnames[i]).item( Integer.valueOf(indexitems[i]) );
            conttemp=eltemp.getTextContent();
          }
          return conttemp;
    }
    public String getContentXml(String pathconfigxml,String tagnamesbypointvirgule,String indexitempointvirgule )throws Exception{
        String[] tagnames= tagnamesbypointvirgule.split(";");
        String[] indexitems=indexitempointvirgule.split(";");
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
          File xmlFile = new File(pathconfigxml);
          Document document = builder.parse(xmlFile);
          Element rootElement= document.getDocumentElement();
          //----------------------------------------------------------------------------------recuperation des class annoter scope
          NodeList nodetemp=null;
          Element eltemp=rootElement;
          String conttemp=null;
          if(tagnames.length!=indexitems.length){ throw new Exception("nombre des tagnames ne correspond pas aux indexitems ("+tagnames.length+" et "+indexitems.length+")"); }
          for(int i=0;i<tagnames.length;i++){
            eltemp=(Element)eltemp.getElementsByTagName(tagnames[i]).item( Integer.valueOf(indexitems[i]) );
            conttemp=eltemp.getTextContent();
          }
          return conttemp;
    }
    public void configByXml(String pathxml)throws Exception{
        Element rooElement=getRootElement(pathxml);
        this.http=getContentXml(rooElement,pathxml,"server;http","0;0" );
        this.host=getContentXml(rooElement,pathxml,"server;host","0;0" );
        this.port=getContentXml(rooElement,pathxml,"server;port","0;0" );

        this.pathjsonAng=getContentXml(rooElement,pathxml,"pathvariablejson;angular","0;0" );;
        this.pathjsonClass=getContentXml(rooElement,pathxml,"pathvariablejson;classe","0;0" );;
        this.pathjsonController=getContentXml(rooElement,pathxml,"pathvariablejson;controller","0;0" );;
    
        //---template 
        //view
        this.pathtemplatehtml=getContentXml(rooElement,pathxml,"pathtemplate;angular;pathtemplatehtml","0;0;0" );;
        this.pathtemplateComponentTs=getContentXml(rooElement,pathxml,"pathtemplate;angular;pathtemplateComponentTs","0;0;0" );;
        this.pathtemplateComponentSpecTs=getContentXml(rooElement,pathxml,"pathtemplate;angular;pathtemplateComponentSpecTs","0;0;0" );;
        this.pathtemplatecompocss=getContentXml(rooElement,pathxml,"pathtemplate;angular;pathtemplatecompocss","0;0;0" );;
    
        this.pathtemplAppComponentHtml=getContentXml(rooElement,pathxml,"pathtemplate;angular;pathtemplAppComponentHtml","0;0;0" );;
        this.pathtemplAppRoutesTs=getContentXml(rooElement,pathxml,"pathtemplate;angular;pathtemplAppRoutesTs","0;0;0" );;
        this.pathtemplAppComponentTs=getContentXml(rooElement,pathxml,"pathtemplate;angular;pathtemplAppComponentTs","0;0;0" );;
        //controller
        this.pathtemplatecontroller=getContentXml(rooElement,pathxml,"pathtemplate;controller","0;0" );;
        this.pathtemplateclass=getContentXml(rooElement,pathxml,"pathtemplate;class","0;0" );;
        //path project
        this.pathproject=getContentXml(rooElement,pathxml,"pathdestination;project","0;0" );
        //databasename
        this.databasename=getContentXml(rooElement,pathxml,"database;databasename","0;0" );
        this.dbport=getContentXml(rooElement,pathxml,"database;port","0;0" );
        this.dbhost=getContentXml(rooElement,pathxml,"database;host","0;0" );
        this.dbusername=getContentXml(rooElement,pathxml,"database;user","0;0" );
        this.dbpassword=getContentXml(rooElement,pathxml,"database;password","0;0" );
    }
    public void afficheFields()throws Exception{
        Field[] fields=getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            System.out.println(fields[i].getName()+"="+fields[i].get(this));
            fields[i].setAccessible(false);
        }
    }
    public void choixTechnoCmd(Scanner scanner)throws Exception{
        // languagebackend et extension
        String choix ="";
        boolean encoure=true;
        //technologie
        while(encoure){
            System.out.println("1:C#");
            //System.out.println("2:Java");
            System.out.print(" technologie :");
            choix = scanner.nextLine();
            if(!choix.isEmpty()){
                if(choix.equalsIgnoreCase("1")){
                    encoure=false;
                    this.languagebackend="csharp";
                    this.extension="cs";
                    this.typecontroller="dotnet";
                }
                // else if(choix.equalsIgnoreCase("2")){
                //     encoure=false;
                //     this.languagebackend="java";
                //     this.extension="java";
                //     this.typecontroller="spring";
                // }
            } 
        }
    }
    public void choixGenereCmd(Scanner scanner,String pathxml)throws Exception{
        // languagebackend et extension
        String choix ="";
        boolean encoure=true;
        while(encoure){
            System.out.println("1:class seulement \n2:controller seulement\n3:class et controller\n4:projet");
            System.out.print(" choix:");
            choix = scanner.nextLine();
            if(!choix.isEmpty()){
                if(choix.equalsIgnoreCase("1")){
                    this.choixgenerer=1;
                    choix = "";
                    while(encoure){
                        System.out.print("package class:");
                        choix = scanner.nextLine();
                        if(!choix.isEmpty()){
                            this.packageclassmodel=choix;
                            encoure=false;
                        }
                    }
                    encoure=false;
                }else if(choix.equalsIgnoreCase("2")){
                    this.choixgenerer=2;
                    choix = "";
                    encoure=true;
                    while(encoure){
                        System.out.print("package controller:");
                        choix = scanner.nextLine();
                        if(!choix.isEmpty()){    this.packagecontroller=choix;   encoure=false; }
                    }
                    choix = "";
                    encoure=true;
                    while(encoure){
                        System.out.print("package class model:");
                        choix = scanner.nextLine();
                        if(!choix.isEmpty()){    this.packageclassmodel=choix;   encoure=false; }
                    }
                    encoure=false;
                }else if(choix.equalsIgnoreCase("3")){
                    this.choixgenerer=3;
                    choix = "";
                    encoure=true;
                    while(encoure){
                        System.out.print("package class:");
                        choix = scanner.nextLine();
                        if(!choix.isEmpty()){
                            this.packageclassmodel=choix;
                            encoure=false;
                        }
                    }
                    encoure=true;
                    while(encoure){
                        System.out.print("package controller:");
                        choix = scanner.nextLine();
                        if(!choix.isEmpty()){
                            this.packagecontroller=choix;
                            encoure=false;
                        }
                    }
                    encoure=false;
                }else if(choix.equalsIgnoreCase("4")){
                    this.choixgenerer=4;
                    encoure=false;
                    //tsy mila ovaina satria efa tonga de miakina @ le config ao @ xml
                    Element rooElement=getRootElement(pathxml);
                            //package
                    if(this.extension.equalsIgnoreCase("java")){
                        this.packageclassmodel=getContentXml(rooElement,pathxml,"packageclass;spring;models","0;0;0" );
                        this.packagecontroller=getContentXml(rooElement,pathxml,"packageclass;spring;controllers","0;0;0" );
                    }else if(this.extension.equalsIgnoreCase("cs")){
                        this.packageclassmodel=getContentXml(rooElement,pathxml,"packageclass;dotnet;models","0;0;0" );
                        this.packagecontroller=getContentXml(rooElement,pathxml,"packageclass;dotnet;models","0;0;0" );
                    }
                }
            }
        }
    }
    public void choixGenereViewCmd(Scanner scanner)throws Exception{
        // languagebackend et extension
        String choix ="";
        boolean encoure=true;
        //technologie
        while(encoure){
            System.out.print("\ngenerer view? y(yes) ou n(no): ");
            choix = scanner.nextLine();
            if(!choix.isEmpty()){
                if(choix.equalsIgnoreCase("y")){
                    this.genereview=true;
                    choix="";
                    while(encoure){
                        System.out.print("1:angular\n");
                        System.out.print(" technologie view :");
                        choix = scanner.nextLine();
                        if(!choix.isEmpty()){
                            if(choix.equalsIgnoreCase("1")){
                                encoure=false;
                                this.languageview="angular";
                            }
                        } 
                    }
                }else if(choix.equalsIgnoreCase("n")){
                    encoure=false;
                    this.genereview=false;
                }
            } 
        }
    }

    public void choixTableAndNameProject(Scanner scanner)throws Exception{
        // languagebackend et extension
        String choix ="";
        boolean encoure=true;
        //technologie
        while(encoure){
            System.out.print("nom de la table (* pour tout la table ): ");
            choix = scanner.nextLine();
            if(!choix.isEmpty()){
                    this.tablename=choix;
                    encoure=false;
            } 
        }
        choix="";
        encoure=true;
        while(encoure){
            System.out.print("nom du projet : ");
            choix = scanner.nextLine();
            if(!choix.isEmpty()){
                    this.nameproject=choix;
                    encoure=false;
            } 
        }
    }
    public void configByCmd(String pathxml)throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("GENERER UN PROJET DEPUIS LES INFORMATION DE LA BASE DE DONNEE");
        choixTechnoCmd(scanner);
        // languagebackend et extension
        choixGenereCmd(scanner, pathxml);
        choixGenereViewCmd(scanner);
        choixTableAndNameProject(scanner);
        
        //SUJET : nom du table du base de donnee ("*" pour tout les tables) : (tablename;)
        //RQ: raha table 1 de le foreign key rehetra reny creer daholo ny table mifanaraka aminy
        //tsy ilaina --> databasetype,
        //efa azo mazava ho azy --> databasename
    }
    public void configByCmdByXml(String pathxml)throws Exception{
            this.configByCmd(pathxml);
            this.configByXml(pathxml);
    }


    public  void copyFolderToFolder(String pathSource,String pathDestination) {
        // Chemin du répertoire source
        System.out.println(pathSource);
        System.out.println(pathDestination);
        File sourceDirectory = new File(pathSource);
        // Chemin du répertoire de destination
        File destinationDirectory = new File(pathDestination);

        try {
            copyDirectory(sourceDirectory, destinationDirectory);
            System.out.println("Copie terminée avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFolderIfNotExiste(String path)throws Exception{
        File folder=new File(path);
        if (folder.exists()==false ) {
            folder.mkdir();
        }
    }


    private  void copyDirectory(File source, File destination) throws IOException {
        // Vérifier si le dossier source existe
        if (!source.exists()) {
            throw new IllegalArgumentException("Le répertoire source n'existe pas:");
        }
        // Vérifier si le dossier destination existe, sinon le créer
        if (!destination.exists()) {
            destination.mkdir();
        }
        // Récupérer tous les fichiers et répertoires dans le dossier source
        File[] files = source.listFiles();
        if (files != null) {
            for (File file : files) {
                File copiedFile = new File(destination, file.getName());
                if (file.isDirectory()) {
                    // Si c'est un répertoire, récursivement copier son contenu
                    copyDirectory(file, copiedFile);
                } else {
                    // Si c'est un fichier, le copier dans le dossier de destination
                    Files.copy(file.toPath(), copiedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }
    public String getStringContainsOfFile(String pathfile)throws Exception{
        System.out.println(pathfile+"<-----------");
        File fichier =  new File(pathfile);
        FileReader fileReader=new FileReader(fichier);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String contenu="";
        String line="";
        while( (line=bufferedReader.readLine())!=null){
            contenu=contenu+line+"\n";
        }
        bufferedReader.close();
        fileReader.close();
        return contenu;
    }

    public void createIfNotExistAndWrite(String path,String contains)throws Exception{
        File fichier = new File(path);
        if (!fichier.exists()) {
            fichier.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(fichier);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(contains);
        bufferedWriter.close();
        fileWriter.close();
    }

    public void createprojet(Connection connection,String pathxml)throws Exception{
        Element rooElement=getRootElement(pathxml);
        //int choixgenerer; //1:class seulement \n 2:controller seulement\n 3:class et controller\n 4:projet"
        //D:/ITUS6/Naina
        if(pathproject.substring(pathproject.length()-1).equalsIgnoreCase("/")==false){ pathproject=pathproject+"/"; }
        String topathclass=pathproject+nameproject+"/classes";
        String topathcontroller=pathproject+nameproject+"/controllers";
        String topathview=pathproject+nameproject+languageview;

        String pathsrcback="";
        String pathsrcview="";
        System.out.println(choixgenerer+" et  "+extension);
        if(choixgenerer==4){
            if(extension.equalsIgnoreCase("cs")){  
                topathclass=pathproject+"/"+nameproject+"/"+getContentXml(rooElement, pathxml,"pathdestination;classes;dotnet", "0;0;0");
                topathcontroller=pathproject+"/"+nameproject+"/"+getContentXml(rooElement, pathxml,"pathdestination;controllers;dotnet", "0;0;0");
                pathsrcback=getContentXml(rooElement, pathxml,"pathsource;backend;dotnet", "0;0;0");
                System.out.println("-->"+pathsrcback);
            
            }else if(extension.equalsIgnoreCase("java")){
                topathclass=pathproject+"/"+nameproject+"/"+getContentXml(rooElement, pathxml,"pathdestination;classes;spring", "0;0;0");
                topathcontroller=pathproject+"/"+nameproject+"/"+getContentXml(rooElement, pathxml,"pathdestination;controllers;spring", "0;0;0");
                pathsrcback=getContentXml(rooElement, pathxml,"pathsource;backend;spring", "0;0;0");
                System.out.println("-->"+pathsrcback);
            }
            createFolderIfNotExiste(pathproject+nameproject);
            copyFolderToFolder(pathsrcback, pathproject+nameproject);
            
        }
        if(genereview==true){
            pathsrcview=getContentXml(rooElement, pathxml,"pathsource;frontend;angular", "0;0;0");
            topathview=pathproject+nameproject+languageview+"/"+getContentXml(rooElement, pathxml,"pathdestination;angular;app", "0;0;0");
            createFolderIfNotExiste(pathproject+nameproject+languagebackend);
            copyFolderToFolder(pathsrcview, pathproject+nameproject+languageview);
        }
        
        String[] typeForGenere={"Table"};
        //int choixgenerer; //1:class seulement \n 2:controller seulement\n 3:class et controller\n 4:projet"
       
        GenereClass gclass=new GenereClass(extension, topathclass, packageclassmodel, typeForGenere, databasename, null, this.pathtemplateclass, this.pathjsonClass);
        if(choixgenerer==1 || choixgenerer==3 || choixgenerer==4){
            gclass.createclasses(connection, tablename);
        }
        GenereController gController=new GenereController(databasename, typecontroller, topathcontroller, packagecontroller, pathtemplatecontroller, pathjsonController, packageclassmodel);
        if(choixgenerer==2 || choixgenerer==3 || choixgenerer==4){
            gController.createControllerOfDataBase(connection, tablename);
        
        }
        //rehefa generer le projet de configurena ny connection
        if(choixgenerer==4){
            String pathtemplconnex="";
            String nameconnexvar="";
            String pathconnex="";
            if(extension.equalsIgnoreCase("cs")){
                pathtemplconnex=getContentXml(rooElement, pathxml,"pathtemplate;connection;dotnet;path", "0;0;0;0");
                nameconnexvar=getContentXml(rooElement, pathxml,"pathtemplate;connection;dotnet;nameclass", "0;0;0;0");
                pathconnex=getContentXml(rooElement, pathxml,"pathdestination;connection;dotnet", "0;0;0");
            }else if (extension.equalsIgnoreCase("java")){
                pathtemplconnex=getContentXml(rooElement, pathxml,"pathtemplate;connection;spring;path", "0;0;0;0");
                nameconnexvar=getContentXml(rooElement, pathxml,"pathtemplate;connection;spring;nameclass", "0;0;0;0");
                pathconnex=getContentXml(rooElement, pathxml,"pathdestination;connection;spring", "0;0;0");
            }
            String connexcontains=getStringContainsOfFile(pathtemplconnex);
            connexcontains=connexcontains.replaceAll("<<host>>", this.dbhost).replaceAll("<<port>>",this.dbport).replaceAll("<<dbusername>>", this.dbusername).replaceAll("<<password>>",this.dbpassword).replaceAll("<<databasename>>", this.databasename);
            pathconnex=pathproject+nameproject+"/"+gController.deletebarLast(pathconnex)+"/"+nameconnexvar+"."+this.extension;
            //ecrire le fichier ver le path de destination
            createIfNotExistAndWrite(pathconnex,connexcontains);
        }
        GenereView gview=new GenereView(databasename, pathjsonAng, languageview, http, host, port, topathview);
        if(genereview==true){
            gview.createPageAngularAndtheAppConfig(connection, tablename, pathtemplatehtml, pathtemplateComponentTs, pathtemplateComponentSpecTs, pathtemplatecompocss, pathtemplAppComponentHtml, pathtemplAppRoutesTs, pathtemplAppComponentTs, typeForGenere);
        }
    }

    public void configAndCreate(Connection connection , String pathxml)throws Exception{
        this.configByCmdByXml(pathxml);
        createprojet(connection, pathxml);
    }
}
