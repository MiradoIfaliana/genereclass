package connect;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.sql.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.nio.file.Files;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import connect.DetailController;

public class GenereController
{ 
    String typeController;
    String topath;
    String packageclass;
    String pathtemplate;
    String pathcontrollerVariable; 
    public GenereController() {
    }
    public GenereController( String typeController, String topath, String packageclass,String pathtemplate, String pathcontrollerVariable) {
        this.typeController = typeController;
        this.topath = topath;
        this.packageclass = packageclass;
        this.pathtemplate = pathtemplate;
        this.pathcontrollerVariable = pathcontrollerVariable;
    }
    public String getTypeController() {
        return typeController;
    }
    public void setTypeController(String typeController) {
        this.typeController = typeController;
    }
    public String getTopath() {
        return topath;
    }
    public void setTopath(String topath) {
        this.topath = topath;
    }
    public String getPackageclass() {
        return packageclass;
    }
    public void setPackageclass(String packageclass) {
        this.packageclass = packageclass;
    }
    public String getPathtemplate() {
        return pathtemplate;
    }
    public void setPathtemplate(String pathtemplate) {
        this.pathtemplate = pathtemplate;
    }
    public String getPathcontrollerVariable() {
        return pathcontrollerVariable;
    }
    public void setPathcontrollerVariable(String pathcontrollerVariable) {
        this.pathcontrollerVariable = pathcontrollerVariable;
    }
    public boolean strExistinliste(Vector<String> vstring,String str){
            for(int i=0;i<vstring.size();i++){ if(str!=null){ if(vstring.elementAt(i).compareTo(str)==0){ return true; } } }
            return false;
    }
    public String getStringIn(String contenu,String strdebut,String strfin){
        int debutIndex = contenu.indexOf(strdebut);
        int finIndex = contenu.indexOf(strfin);
        if(debutIndex==-1 || finIndex==-1){ return ""; }
        String thestr=contenu.substring(debutIndex+strdebut.length(),finIndex);
        return thestr;
    }
    //rehefa -1 le izy de tsy atao fotsiny
    public String toUpperCaseFirst(String str){ return str.toUpperCase().substring(0,1)+str.substring(1,str.length()); } 
    public String toLowerCaseFirst(String str){ return str.toLowerCase().substring(0,1)+str.substring(1,str.length()); }

    public DetailController getDetailControllerByTypeController()throws Exception{
        String jsonFilePath = this.pathcontrollerVariable;
        try{
            FileReader reader = new FileReader(jsonFilePath);
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            // Récupérer la partie "dotnet" du JSON
            JsonObject dotnetObject = jsonObject.getAsJsonObject(this.typeController);
            Gson gson = new Gson();
            DetailController detailController = gson.fromJson(dotnetObject, DetailController.class);
            reader.close();
            return detailController;
        }catch(IOException io){throw io;
        }catch(Exception ex){throw ex; }
    }
    public String getTemplate()throws Exception{
        File fichier =  new File(this.pathtemplate);
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
        //contenu=contenu.replaceAll("<Nameclass>", "Article");
    }
    public String getCreateTemplate(String template,DetailController detailController)throws Exception{
        String contenu=template+"";
        Field[] fields=detailController.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            contenu=contenu.replaceAll( "#"+fields[i].getName()+"#", fields[i].get(detailController).toString());
            fields[i].setAccessible(false);
        }
        return contenu;
    }
    public String getJustCodeCrud(String template,String className){
        String mTemplate=template+"";
        String crud=getStringIn(mTemplate,"<crud>","</crud>");
        crud=crud.replaceAll("<Typeclass>", className);
        //Create
        String create=getStringIn(crud,"<create>","</create>");
        create=create.replaceAll("<endpoint>", "/Create"+className);
        create=create.replaceAll("<Typereturn>", "String");
        create=create.replaceAll("<TypeRequest>", className);
        create=create.replaceAll("<variablereturn>", "resultat");
        //Read
        String read=getStringIn(crud,"<read>","</read>");
        read=read.replaceAll("<endpoint>", "/Read"+className);
        read=read.replaceAll("<Typereturn>", className+"[]");
        read=read.replaceAll("<variablereturn>", "resultats");
        //Update
        String update=getStringIn(crud,"<update>","</update>");
        update=update.replaceAll("<endpoint>", "/Update"+className);
        update=update.replaceAll("<Typereturn>", "String");
        update=update.replaceAll("<TypeRequest>", className);
        update=update.replaceAll("<variablereturn>", "resultat");
        //Delete
        String delete=getStringIn(crud,"<delete>","</delete>");
        delete=delete.replaceAll("<endpoint>", "/Delete"+className);
        delete=delete.replaceAll("<Typereturn>", "String");
        delete=delete.replaceAll("<variablereturn>", "resultat");
        String codeCrud=create+read+update+delete;
        return codeCrud;
    }
    public String getCodeGenerateController(DetailController detailController,String className)throws Exception{
        String template=getTemplate();
        template=getCreateTemplate(template, detailController);
        template=template.replaceAll("<package>", this.packageclass);//package
        int index1=template.indexOf("<library>");//lib
        int index2=template.indexOf("</library>")+"</library>".length();
        template=template.substring(0, index1)+template.substring(index2); //pas d'importation pour le moment
        String classNameUp=toUpperCaseFirst(className);//class name
        template=template.replaceAll("<routeController>","/api/"+classNameUp+"Controller");
        template=template.replaceAll( "<Namecontroller>" , classNameUp+"Controller");        
        String crud=getJustCodeCrud(template, classNameUp);
        index1=template.indexOf("<crud>");
        index2=template.indexOf("</crud>")+"</crud>".length();
        String contenu=template.substring(0, index1)+crud+template.substring(index2);
        return contenu;
    }
    public void createclassbytablename(String className)throws Exception{
        DetailController detailController=getDetailControllerByTypeController();
        String code=this.getCodeGenerateController(detailController,className);
        if(this.topath.substring(this.topath.length()-1).compareTo("/")!=0){ this.topath+="/"; }
        File fichier = new File(this.topath+toUpperCaseFirst(className)+"Controller"+"."+detailController.getExtension());
        if (!fichier.exists()) {
            fichier.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(fichier);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(code);
        bufferedWriter.close();
        fileWriter.close();
    }

}