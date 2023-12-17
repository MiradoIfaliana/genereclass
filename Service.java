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

public class Service
{ 
    String extension;
    String topath;
    String packageclass;
    String[] typeforgenere;
    String databasename;
    String databasetype;  
    String pathtemplate;
    String pathClassvariable;

    
    public Service() {
    }
    public Service(String extension, String topath, String packageclass, String[] typeforgenere, String databasename,String databasetype,String pathtemplate,String pathClassvariable) {
        setExtension(extension);
        setTopath(topath);
        setPackageclass(packageclass);
        setTypeforgenere(typeforgenere);
        setDatabasename(databasename);
        setDatabasetype(databasetype);
        setPathtemplate(pathtemplate);
        setPathClassvariable(pathClassvariable);
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
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
    public String[] getTypeforgenere() {
        return typeforgenere;
    }
    public void setTypeforgenere(String[] typeforgenere) {
        this.typeforgenere = typeforgenere;
    }
    public String getDatabasename() {
        return databasename;
    }
    public void setDatabasename(String databasename) {
        this.databasename = databasename;
    }
    public String getDatabasetype() {
        return databasetype;
    }
    public void setDatabasetype(String databasetype) {
        this.databasetype = databasetype;
    }
    public String getPathtemplate() {
        return pathtemplate;
    }
    public void setPathtemplate(String pathtemplate) {
        this.pathtemplate = pathtemplate;
    }
    public String getPathClassvariable() {
        return pathClassvariable;
    }
    public void setPathClassvariable(String pathClassvariable) {
        this.pathClassvariable = pathClassvariable;
    }
    private static String[] getCsTypeNameAndLib(int sqlType) {
        String[] nameAndLib = new String[2];
        switch (sqlType) {
            case Types.INTEGER:
                nameAndLib[0] = "int";
                break;
            case Types.SMALLINT:
                nameAndLib[0] = "short";
                break;
            case Types.BIGINT:
                nameAndLib[0] = "long";
                break;
            case Types.NUMERIC:
                nameAndLib[0] = "decimal";
                nameAndLib[1] = "System";
                break;
            case Types.REAL:
                nameAndLib[0] = "float";
                break;
            case Types.DOUBLE:
            case Types.FLOAT:
                nameAndLib[0] = "double";
                break;
            case Types.CHAR:
            case Types.NCHAR:
            case Types.VARCHAR:
            case Types.NVARCHAR:
            case Types.LONGVARCHAR:
            case Types.LONGNVARCHAR:
            case Types.CLOB:
            case Types.NCLOB:
                nameAndLib[0] = "string";
                break;
            case Types.DATE:
                nameAndLib[0] = "DateTime";
                nameAndLib[1] = "System";
                break;
            case Types.TIME:
                nameAndLib[0] = "TimeSpan";
                nameAndLib[1] = "System.TimeSpan";
                break;
            case Types.TIMESTAMP:
                nameAndLib[0] = "DateTime";
                nameAndLib[1] = "System";
                break;
            case Types.BOOLEAN:
            case Types.BIT:
                nameAndLib[0] = "bool";
                break;
            case Types.BINARY:
            case Types.VARBINARY:
            case Types.LONGVARBINARY:
            case Types.BLOB:
                nameAndLib[0] = "byte[]";
                break;
            // Ajoutez d'autres cas selon les types de données nécessaires
            default:
                nameAndLib[0] = "Non géré";
                break;
        }
        return nameAndLib;
    }


    public static String[] getJavaTypeNameAndLib(int sqlType) {
        String[] nameAndLib = new String[2];
        switch (sqlType) {
            case Types.INTEGER:
                nameAndLib[0] = "int";
                break;
            case Types.SMALLINT:
                nameAndLib[0] = "short";
                break;
            case Types.BIGINT:
                nameAndLib[0] = "long";
                break;
            case Types.NUMERIC:
                nameAndLib[0] = "BigDecimal";
                nameAndLib[1] = "java.math.BigDecimal";
                break;
            case Types.REAL:
                nameAndLib[0] = "float";
                break;
            case Types.DOUBLE:
            case Types.FLOAT:
                nameAndLib[0] = "double";
                break;
            case Types.CHAR:
            case Types.NCHAR:
            case Types.VARCHAR:
            case Types.NVARCHAR:
            case Types.LONGVARCHAR:
            case Types.LONGNVARCHAR:
            case Types.CLOB:
            case Types.NCLOB:
                nameAndLib[0] = "String";
                break;
            case Types.DATE:
                nameAndLib[0]="Date";
                nameAndLib[1]="java.sql.Date";
                break;
            case Types.TIME:
                nameAndLib[0] = "Time";
                nameAndLib[1] = "java.sql.Time";
                break;
            case Types.TIMESTAMP:
                nameAndLib[0] = "LocalDateTime";
                nameAndLib[1] = "java.time.LocalDateTime";
                break;
            case Types.BOOLEAN:
            case Types.BIT:
                nameAndLib[0] = "boolean";
                break;
            case Types.BINARY:
            case Types.VARBINARY:
            case Types.LONGVARBINARY:
            case Types.BLOB:
                nameAndLib[0] = "byte[]";
                break;
            default:
                nameAndLib[0] = "<Non géré>";
                break;
        }
        return nameAndLib;
    }

  public boolean strExistinliste(Vector<String> vstring,String str){
        for(int i=0;i<vstring.size();i++){ if(str!=null){ if(vstring.elementAt(i).compareTo(str)==0){ return true; } } }
        return false;
  }
  public Vector<String[]> getTablesInfoOfDatebase(DatabaseMetaData metaData ,String[] typeForGenere)throws Exception{//[0]=tablename,[1]=tabletype,[2]=tableschem
        if(typeForGenere==null){
            typeForGenere=new String[1];
            typeForGenere[0]="TABLE";
        }else{ for(int i=0;i<typeForGenere.length;i++){ typeForGenere[i]=typeForGenere[i].toUpperCase(); } }
        ResultSet table =metaData.getTables(this.databasename, "public", null, typeForGenere);
        //ResultSet table = metaData.getFunctions(this.databasename, "public", null); ---FUNCTION
        String[] tabsinfo=null;
        Vector<String[]> vTab=new Vector<String[]>(); 
        while (table.next()) {
                           // Faites quelque chose avec les informations récupérées
                // System.out.print("Catalogue : " + table.getString("TABLE_CAT"));
                // System.out.print("  Schéma : " + table.getString("TABLE_SCHEM"));
                // System.out.print("  Nom de la table : " + table.getString("TABLE_NAME"));
                // System.out.print("  Type de table : " + table.getString("TABLE_TYPE"));
                // System.out.print("  Remarques : " + table.getString("REMARKS")+"\n");
                // System.out.print("----------------------");

            tabsinfo=new String[3];
            tabsinfo[0]=table.getString("TABLE_NAME");
            tabsinfo[1]=table.getString("TABLE_TYPE");
            tabsinfo[2]=table.getString("TABLE_SCHEM");
            //tabsinfo[0]=table.getString("FUNCTION_NAME");//---FUNCTION
            vTab.add(tabsinfo);
         }
        table.close();
        return vTab;
  }
  //String nametable, String columnname, String columntype, String columntechtype, String libimport
    public Vector<DetailTable> infotable(DatabaseMetaData metaData,String tablename)throws Exception{
            ResultSet columns = metaData.getColumns(null, null, tablename, null);
            //ResultSet columns = metaData.getProcedureColumns(null, null, tablename, null); //FUNCTION
            Vector<DetailTable> vDet=new Vector<DetailTable>();
            DetailTable detailTable=null;
            Vector<String> vlib=new Vector<String>();
            String columnName=null;
            String columnType=null;
            int columnTypeTech=0;
            String[] typeAndLib=null;
            while (columns.next()) {
                columnName = columns.getString("COLUMN_NAME");
                columnType = columns.getString("TYPE_NAME");
                columnTypeTech = columns.getInt("DATA_TYPE");
                typeAndLib =null;
                if(this.extension.compareToIgnoreCase("java")==0){ 
                    typeAndLib=getJavaTypeNameAndLib(columnTypeTech);
                }else if(this.extension.compareToIgnoreCase("cs")==0){
                    typeAndLib=getCsTypeNameAndLib(columnTypeTech);
                }
                if(typeAndLib[1]!=null){//verifiena hoe efa misy ve le import
                    if(strExistinliste(vlib, typeAndLib[1])==true){ typeAndLib[1]=null;  }
                    else { vlib.add(typeAndLib[1]); }
                }
                detailTable=new DetailTable(tablename.substring(0,1).toUpperCase()+tablename.substring(1,tablename.length()),columnName+"", columnType+"", typeAndLib[0], typeAndLib[1]);
                vDet.add(detailTable);
                //System.out.println("Nom: " + detailTable.getNametable()+"\nType: " +detailTable.getColumntype()+"\nType en Tech: " + detailTable.getColumntechtype()+"-----------------------");
            }
            columns.close();
            return vDet;
    }
    public DetailClass getDetailClassByExtension()throws Exception{
        String jsonFilePath = this.pathClassvariable;
        try{
            FileReader reader = new FileReader(jsonFilePath);
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            // Récupérer la partie du JSON
            JsonObject dotnetObject = jsonObject.getAsJsonObject(this.extension);//ex :"cs"--->"cs":{ classvariable }
            Gson gson = new Gson();
            DetailClass detailClass = gson.fromJson(dotnetObject, DetailClass.class);
            reader.close();
            return detailClass;
        }catch(IOException io){throw io;}
        catch(Exception ex){ throw ex;}
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
    public String getCreateTemplate(String template,DetailClass detailClass)throws Exception{
        String contenu=template+"";
        Field[] fields=detailClass.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            //System.out.println(fields[i].getName());
            contenu=contenu.replaceAll( "#"+fields[i].getName()+"#", fields[i].get(detailClass).toString());
            fields[i].setAccessible(false);
        }
        return contenu;
    }
    public String getTemplateOfExtension()throws Exception{
            DetailClass detailClass=getDetailClassByExtension();
            String template=getTemplate();
            String contenu=getCreateTemplate(template, detailClass);
            return contenu;
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

    public String getCodeStringClassByTablename(DatabaseMetaData metaData,String tablename)throws Exception{
        Vector<DetailTable> vDetailTables=infotable(metaData, tablename);
        String template=getTemplateOfExtension();
        String classname=toUpperCaseFirst(tablename);
        template=template.replaceAll("<package>", this.packageclass);//
        template=template.replaceAll("<Nameclass>", classname);//
        DetailTable detailTable=null;
        String libraryTemplate=getStringIn(template, "<library>", "</library>");
        String library="";
        String fieldTemplate=getStringIn(template, "<field>", "</field>");
        String field="";
        String getsetfieldTemplate=getStringIn(template, "<getsetfield>", "</getsetfield>");
        String getsetfield="";
        for(int i=0;i<vDetailTables.size();i++){
            detailTable=vDetailTables.elementAt(i);
            if(detailTable.getLibimport()!=null){ 
                library+=libraryTemplate.replaceAll("<lib>", detailTable.getLibimport())+"\n";
            }
            field+=fieldTemplate.replaceAll("<typefield>",detailTable.getColumntechtype()).replaceAll("<namefield>", detailTable.getColumnname())+"\n";
            getsetfield+=getsetfieldTemplate.replaceAll("<typefield>", detailTable.getColumntechtype()).replaceAll("<Namefield>", toUpperCaseFirst(detailTable.getColumnname()) ).replaceAll("<namefield>", detailTable.getColumnname())+"\n";
        }
        int indexdebut=template.indexOf("<library>");
        int indexfin=template.indexOf("</library>"); //remplacena le eo ampovoany
        if(indexdebut!=-1 && indexfin!=-1){ 
            template=template.substring(0,indexdebut)+library+template.substring(indexfin+"</library>".length(), template.length());
        }
        indexdebut=template.indexOf("<field>");
        indexfin=template.indexOf("</field>"); //remplacena le eo ampovoany
        if(indexdebut!=-1 && indexfin!=-1){ 
            template=template.substring(0,indexdebut)+field+template.substring(indexfin+"</field>".length(), template.length());
        }
        indexdebut=template.indexOf("<getsetfield>");
        indexfin=template.indexOf("</getsetfield>"); //remplacena le eo ampovoany
        if(indexdebut!=-1 && indexfin!=-1){ 
            template=template.substring(0,indexdebut)+getsetfield+template.substring(indexfin+"</getsetfield>".length(), template.length());
        }
        return template;
    } 

    public void createclassbytablename(DatabaseMetaData metaData,String tablename)throws Exception{
        String code=this.getCodeStringClassByTablename(metaData, tablename);
        if(this.topath.substring(topath.length()-1).compareTo("/")!=0){ this.topath+="/"; }
        File fichier = new File(this.topath+toUpperCaseFirst(tablename)+"."+this.extension);
        if (!fichier.exists()) {
            fichier.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(fichier);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(code);
        bufferedWriter.close();
        fileWriter.close();
    }
    public void createclassOfdatabase(Connection connection)throws Exception{
        DatabaseMetaData metaData=connection.getMetaData();
        Vector<String[]> vinfotab=this.getTablesInfoOfDatebase(metaData, this.typeforgenere);
        String[] infotab=null;
        for(int i=0;i<vinfotab.size();i++){
            infotab=vinfotab.elementAt(i);//[0]=tablename,[1]=tabletype,[2]=tableschem
            createclassbytablename(metaData,infotab[0]);
        }
    }

    public String createorreplaceIfExist(String codecontenu){
        int index1=codecontenu.indexOf(" class ");
        int index2=index1+" class ".length()-1;
        index2=codecontenu.substring(index2).indexOf("{")+1;
        Vector<String> attribu=new Vector<String>();
        String contenu=codecontenu.substring(index1, index2);
        return "";
    }

    public String getCodeStringClassByTablename2(DatabaseMetaData metaData,String tablename,String lastcode)throws Exception{
        Vector<DetailTable> vDetailTables=infotable(metaData, tablename);
        String template=getTemplateOfExtension();
        String classname=toUpperCaseFirst(tablename);
        template=template.replaceAll("<package>", this.packageclass);//
        template=template.replaceAll("<Nameclass>", classname);//
        DetailTable detailTable=null;
        String libraryTemplate=getStringIn(template, "<library>", "</library>");
        String library="";
        String fieldTemplate=getStringIn(template, "<field>", "</field>");
        String field="";
        String getsetfieldTemplate=getStringIn(template, "<getsetfield>", "</getsetfield>");
        String getsetfield="";
        String strtemp="";
        for(int i=0;i<vDetailTables.size();i++){
            detailTable=vDetailTables.elementAt(i);
            if(detailTable.getLibimport()!=null){ 
                strtemp=libraryTemplate.replaceAll("<lib>", detailTable.getLibimport());
                if(lastcode.contains(strtemp)==false){ //raha efa misy
                    library+=strtemp+"\n";
                }
            }
            strtemp=fieldTemplate.replaceAll("<typefield>",detailTable.getColumntechtype()).replaceAll("<namefield>", detailTable.getColumnname());
            if(lastcode.contains(strtemp)==false){ //raha efa misy
                field+=strtemp+"\n";
            }
            getsetfield+=getsetfieldTemplate.replaceAll("<typefield>", detailTable.getColumntechtype()).replaceAll("<Namefield>", toUpperCaseFirst(detailTable.getColumnname()) ).replaceAll("<namefield>", detailTable.getColumnname())+"\n";
        }
        int indexdebut=template.indexOf("<library>");
        int indexfin=template.indexOf("</library>"); //remplacena le eo ampovoany
        if(indexdebut!=-1 && indexfin!=-1){ 
            template=template.substring(0,indexdebut)+library+template.substring(indexfin+"</library>".length(), template.length());
        }
        indexdebut=template.indexOf("<field>");
        indexfin=template.indexOf("</field>"); //remplacena le eo ampovoany
        if(indexdebut!=-1 && indexfin!=-1){ 
            template=template.substring(0,indexdebut)+field+template.substring(indexfin+"</field>".length(), template.length());
        }
        indexdebut=template.indexOf("<getsetfield>");
        indexfin=template.indexOf("</getsetfield>"); //remplacena le eo ampovoany
        if(indexdebut!=-1 && indexfin!=-1){ 
            template=template.substring(0,indexdebut)+getsetfield+template.substring(indexfin+"</getsetfield>".length(), template.length());
        }
        return template;
    } 
}