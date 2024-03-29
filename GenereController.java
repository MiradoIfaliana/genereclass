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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.nio.file.Files;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GenereController
{ 
    String typeController;
    String topath;
    String packageclass;
    String pathtemplate;
    String pathcontrollerVariable; 
    String packagemodels;
    String databasename;
    public GenereController() {
    }//package
    public GenereController(String databasename,String typeController, String topath, String packageclass,String pathtemplate, String pathcontrollerVariable,String packagemodels) {
        this.databasename=databasename;
        this.typeController = typeController;
        this.topath = topath;
        this.packageclass = packageclass;
        this.pathtemplate = pathtemplate;
        this.pathcontrollerVariable = pathcontrollerVariable;
        this.packagemodels=packagemodels;
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
    public String getPackagemodels() {
        return packagemodels;
    }
    public void setPackagemodels(String packagemodels) {
        this.packagemodels = packagemodels;
    }
    public String getDatabasename() {
        return databasename;
    }
    public void setDatabasename(String databasename) {
        this.databasename = databasename;
    }
    public boolean strExistinliste(Vector<String> vstring,String str){
            for(int i=0;i<vstring.size();i++){ if(str!=null){ if(vstring.elementAt(i).compareTo(str)==0){ return true; } } }
            return false;
    }
    public String getStringIn(String contenu,String strdebut,String strfin){
        //ex = "<1>koko<2>" ---> "koko" 
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
    public int[] getIndexOfContenu(String contenu,String balise1,String balise2){
        int[] index=new int[2];
        index[0]=contenu.indexOf(balise1);
        index[1]=contenu.indexOf(balise2)+balise2.length();
        return index;

    }
    //public String toUpperCaseFirst(String str){ return str.toUpperCase().substring(0,1)+str.substring(1,str.length()); }
    public String getJustCodeCrud(String template,String className,String tablename,String namepk,DetailController detailController,DatabaseMetaData metaData)throws Exception{
        String mTemplate=template+"";
        String crud=getStringIn(mTemplate,"<crud>","</crud>");
        String classLower=toLowerCaseFirst(className);
        crud=crud.replaceAll("<Typeclass>", className);
        String instancetemp=detailController.getToinstance().replaceAll( "<Type>",detailController.getTypegettersconnection());//instanciation
        crud=crud.replaceAll("<instancegettersconnection>", instancetemp );
        instancetemp=detailController.getToinstance().replaceAll( "<Type>",detailController.getTyperesponse());//instanciation
        crud=crud.replaceAll("<instancetyperesponse>", instancetemp );
        instancetemp=detailController.getToinstance().replaceAll( "<Type>",className);//instanciation
        crud=crud.replaceAll("<instancetypeclass>", instancetemp);
        crud=crud.replaceAll("<Typeclass>", className);
        crud=crud.replaceAll("<typeclass>", classLower);
        crud=crud.replaceAll("<namepk>", namepk);
        crud=crud.replaceAll("<Namepk>", toUpperCaseFirst(namepk));
        ///
        String setresponseTmplt="";
        String setreponse="";
        int[] index=new int[2];
        //getIndexOfContenu(String contenu,String balise1,String balise2)
        //Create
        String create=getStringIn(crud,"<create>","</create>");
        create=create.replaceAll("<endpoint>", "create"+className);
            //try
            setresponseTmplt=getStringIn(create, "<responsetry>", "</responsetry>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatussucces());
            index=getIndexOfContenu(create, "<responsetry>", "</responsetry>");
            if(index[0]>=0 && index[1]>=0){
                create=create.substring(0,index[0])+setreponse+create.substring(index[1], create.length());
            }
            //catch
            setreponse="";
            setresponseTmplt=getStringIn(create, "<responsecatch>", "</responsecatch>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatuserror());
            setreponse+="\n"+setresponseTmplt.replaceAll("<keyrep>","message" ).replaceAll("<valueresponse>", detailController.getGetmsgexception());
            index=getIndexOfContenu(create, "<responsecatch>", "</responsecatch>");
            if(index[0]>=0 && index[1]>=0){
                create=create.substring(0,index[0])+setreponse+create.substring(index[1], create.length());
            }
        //Read
        String read=getStringIn(crud,"<read>","</read>");
        read=read.replaceAll("<endpoint>", "read"+className);
            //try
            setreponse="";
            setresponseTmplt=getStringIn(read, "<responsetry>", "</responsetry>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatussucces());
            setreponse+="\n"+setresponseTmplt.replaceAll("<keyrep>","data" ).replaceAll("<valueresponse>", classLower+"."+detailController.getMethodread());
            index=getIndexOfContenu(read, "<responsetry>", "</responsetry>");
            if(index[0]>=0 && index[1]>=0){
                read=read.substring(0,index[0])+setreponse+read.substring(index[1], read.length());
            }
            //catch
            setreponse="";
            setresponseTmplt=getStringIn(read, "<responsecatch>", "</responsecatch>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatuserror());
            setreponse+="\n"+setresponseTmplt.replaceAll("<keyrep>","message" ).replaceAll("<valueresponse>", detailController.getGetmsgexception());
            index=getIndexOfContenu(read, "<responsecatch>", "</responsecatch>");
            if(index[0]>=0 && index[1]>=0){
                read=read.substring(0,index[0])+setreponse+read.substring(index[1], read.length());
            }
        //readdetailed
        String readdetailed=getStringIn(crud,"<readDetailed>","</readDetailed>");
        readdetailed=readdetailed.replaceAll("<endpoint>", "read"+className+"Detailed");
        String query=this.createQueryForBestList(this.getTableInfo(metaData, tablename), metaData);
        readdetailed=readdetailed.replaceAll("<queryreaddetailed>", query);
        //<queryreaddetailed>
            //try
            setreponse="";
            setresponseTmplt=getStringIn(readdetailed, "<responsetry>", "</responsetry>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatussucces());
            setreponse+="\n"+setresponseTmplt.replaceAll("<keyrep>","data" ).replaceAll("<valueresponse>", classLower+"."+detailController.getMethodreaddetailed());
            index=getIndexOfContenu(readdetailed, "<responsetry>", "</responsetry>");
            if(index[0]>=0 && index[1]>=0){
                readdetailed=readdetailed.substring(0,index[0])+setreponse+readdetailed.substring(index[1], readdetailed.length());
            }
            //catch
            setreponse="";
            setresponseTmplt=getStringIn(readdetailed, "<responsecatch>", "</responsecatch>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatuserror());
            setreponse+="\n"+setresponseTmplt.replaceAll("<keyrep>","message" ).replaceAll("<valueresponse>", detailController.getGetmsgexception());
            index=getIndexOfContenu(readdetailed, "<responsecatch>", "</responsecatch>");
            if(index[0]>=0 && index[1]>=0){
                readdetailed=readdetailed.substring(0,index[0])+setreponse+readdetailed.substring(index[1], readdetailed.length());
            }
        //ReadById
        String readById=getStringIn(crud,"<readById>","</readById>");
        readById=readById.replaceAll("<endpoint>", "read"+className+"ById");
            //try
            setreponse="";
            setresponseTmplt=getStringIn(readById, "<responsetry>", "</responsetry>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatussucces());
            setreponse+="\n"+setresponseTmplt.replaceAll("<keyrep>","data" ).replaceAll("<valueresponse>", classLower+"."+detailController.getMethodreadbyid());
            index=getIndexOfContenu(readById, "<responsetry>", "</responsetry>");
            if(index[0]>=0 && index[1]>=0){
                readById=readById.substring(0,index[0])+setreponse+readById.substring(index[1], readById.length());
            }
            //catch
            setreponse="";
            setresponseTmplt=getStringIn(readById, "<responsecatch>", "</responsecatch>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatuserror());
            setreponse+="\n"+setresponseTmplt.replaceAll("<keyrep>","message" ).replaceAll("<valueresponse>", detailController.getGetmsgexception());
            index=getIndexOfContenu(readById, "<responsecatch>", "</responsecatch>");
            if(index[0]>=0 && index[1]>=0){
                readById=readById.substring(0,index[0])+setreponse+readById.substring(index[1], readById.length());
            }
        //setreponse+="\n"+setresponseTmplt.replaceAll("<keyrep>","data" ).replaceAll("<valueresponse>", detailController.getStatussucces());
        //Update//<readById>
        String update=getStringIn(crud,"<update>","</update>");
        update=update.replaceAll("<endpoint>", "update"+className);
            //try
            setreponse="";
            setresponseTmplt=getStringIn(update, "<responsetry>", "</responsetry>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatussucces());
            index=getIndexOfContenu(update, "<responsetry>", "</responsetry>");
            if(index[0]>=0 && index[1]>=0){
                update=update.substring(0,index[0])+setreponse+update.substring(index[1], update.length());
            }
            //catch
            setreponse="";
            setresponseTmplt=getStringIn(update, "<responsecatch>", "</responsecatch>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatuserror());
            setreponse+="\n"+setresponseTmplt.replaceAll("<keyrep>","message" ).replaceAll("<valueresponse>", detailController.getGetmsgexception());
            index=getIndexOfContenu(update, "<responsecatch>", "</responsecatch>");
            if(index[0]>=0 && index[1]>=0){
                update=update.substring(0,index[0])+setreponse+update.substring(index[1], update.length());
            }
        //Delete
        String delete=getStringIn(crud,"<delete>","</delete>");
        delete=delete.replaceAll("<endpoint>", "delete"+className);
            //try
            setreponse="";
            setresponseTmplt=getStringIn(delete, "<responsetry>", "</responsetry>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatussucces());
            index=getIndexOfContenu(delete, "<responsetry>", "</responsetry>");
            if(index[0]>=0 && index[1]>=0){
                delete=delete.substring(0,index[0])+setreponse+delete.substring(index[1], delete.length());
            }
            //catch
            setreponse="";
            setresponseTmplt=getStringIn(delete, "<responsecatch>", "</responsecatch>");
            setreponse+=setresponseTmplt.replaceAll("<keyrep>","status" ).replaceAll("<valueresponse>", detailController.getStatuserror());
            setreponse+="\n"+setresponseTmplt.replaceAll("<keyrep>","message" ).replaceAll("<valueresponse>", detailController.getGetmsgexception());
            index=getIndexOfContenu(delete, "<responsecatch>", "</responsecatch>");
            if(index[0]>=0 && index[1]>=0){
                delete=delete.substring(0,index[0])+setreponse+delete.substring(index[1], delete.length());
            }
        String codeCrud=create+read+readdetailed+readById+update+delete;
        return codeCrud;
    }
    public String getCodeGenerateController(DetailController detailController,String className,String tablename,String namepk,DatabaseMetaData metaData)throws Exception{
        String template=getTemplate();
        template=getCreateTemplate(template, detailController);
        template=template.replaceAll("<package>", this.packageclass);//package
        String libTemplate=getStringIn(template,"<library>","</library>");//lib
        String lib="";
        String[] libraries=detailController.getLibraries();
        if(libraries!=null){
            for(int i=0;i<libraries.length;i++){
                lib+="\n"+libTemplate.replaceAll("<lib>",libraries[i]);
            }
        }
        lib+="\n"+libTemplate.replaceAll("<lib>", packagemodels);
        int index1=template.indexOf("<library>");
        int index2=template.indexOf("</library>")+"</library>".length();
        template=template.substring(0, index1)+lib+template.substring(index2); //ajout importations
        String classNameUp=toUpperCaseFirst(className);//class name
        template=template.replaceAll("<Typeclass>",classNameUp);
        template=template.replaceAll( "<Namecontroller>" , classNameUp+"Controller");        
        String crud=getJustCodeCrud(template, classNameUp,tablename,namepk,detailController,metaData);
        index1=template.indexOf("<crud>");
        index2=template.indexOf("</crud>")+"</crud>".length();
        String contenu=template.substring(0, index1)+crud+template.substring(index2);
        return contenu;
    }
    public void createFolderIfNotExiste(String path)throws Exception{
        File folder=new File(path);
        if (folder.exists()==false ) {
            folder.mkdir();
        }
    }
    public String deletebarLast(String str){
        String p=str+"";
        if(str.isEmpty()==false){
            if(p.substring(p.length()-1).compareTo("/")==0){ 
                p=p.substring(0,p.length()-1); 
            }
        }
        return p;
    }
    public void createclassbytablename(String className,String tablename,String namepk,DatabaseMetaData metaData)throws Exception{
        DetailController detailController=getDetailControllerByTypeController();
        String code=this.getCodeGenerateController(detailController,className,tablename,namepk,metaData);
        if(this.topath.substring(this.topath.length()-1).compareTo("/")!=0){ this.topath+="/"; }
        createFolderIfNotExiste(deletebarLast(this.topath));
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
    public List<String> getPrimaryKeys(DatabaseMetaData metaData,String nametable)throws Exception{
        ResultSet pkeys= metaData.getPrimaryKeys(null, null, nametable);
        List<String> pkname=new ArrayList<String>();//colonnename //tablename //originname
        while (pkeys.next()) {
            pkname.add(pkeys.getString("COLUMN_NAME"));
        }
        pkeys.close();
        return pkname;
    }

    public List<String[]> getForeignKeys(DatabaseMetaData metaData,String nametable)throws Exception{
        ResultSet fkeys = metaData.getImportedKeys(null, null, nametable);
        List<String[]> fkname=new ArrayList<String[]>();//tableoriginename //originname //etrangerename
        String[] temps=null;
        while (fkeys.next()) {
                temps=new String[3];
                temps[0]=fkeys.getString("PKTABLE_NAME");//table origine
                temps[1]=fkeys.getString("PKCOLUMN_NAME");//le vrai nom en tant que pk dans le table origin 
                temps[2]=fkeys.getString("FKCOLUMN_NAME");//le non en tant que entranger
                fkname.add(temps);
        }
        fkeys.close();
        return fkname;
    }

    public TableInfo getTableInfo( DatabaseMetaData metaData,String nametable)throws Exception{
        List<String> pkname=getPrimaryKeys(metaData, nametable);
        List<String[]> fkname=getForeignKeys(metaData,nametable);

        ResultSet columnsResultSet = metaData.getColumns(null, null, nametable, null);
        List<ColumnInfo> lstcol=new ArrayList<ColumnInfo>();
        ColumnInfo col=new ColumnInfo();
        while (columnsResultSet.next()) {
            col=new ColumnInfo();
            col.setName(columnsResultSet.getString("COLUMN_NAME"));
            //si c'est un pk
            for(int i=0;i<pkname.size();i++){
                if(col.getName().equals(pkname.get(i))==true){
                    col.setEstPK(true);
                    col.setEstFK(false);
                    i=pkname.size();//fin boucle
                }
            }
            //si c'est un fk
            for(int i=0;i<fkname.size();i++){
                if(col.getName().equals(fkname.get(i)[2])==true){
                    col.setEstFK(true);
                    col.setTabOriginFk(fkname.get(i)[0]);
                    col.setColFromOrigin(fkname.get(i)[1]);
                    i=fkname.size();//fin boucle
                }
            }
            lstcol.add(col);
        }
        columnsResultSet.close();
        TableInfo tabinfo=new TableInfo(nametable,lstcol);
        return tabinfo;
    }
    public List<TableInfo> getListeTableInfo(DatabaseMetaData metaData,String[] nametables)throws Exception{
        List<TableInfo> ltab=new ArrayList<TableInfo>();
        TableInfo tabtmp=null;
        for(int i=0;i<nametables.length;i++){
            tabtmp=getTableInfo(metaData, nametables[i]);
            ltab.add(tabtmp);
        }
        return ltab;
    }
    public String getFirstPkname(TableInfo tableinfo)throws Exception{
        for(int i=0;i<tableinfo.lstcol.size();i++){  if(tableinfo.lstcol.get(i).isEstPK()==true){ return tableinfo.lstcol.get(i).getName(); } 
        }throw new Exception("primary key obligatoire pour table "+tableinfo.getTablename()); 
    }
    public String[] getTableNames(DatabaseMetaData metaData ,String[] typeForGenere)throws Exception{//[0]=tablename,[1]=tabletype,[2]=tableschem
        if(typeForGenere==null){
            typeForGenere=new String[1];
            typeForGenere[0]="TABLE";
        }else{ for(int i=0;i<typeForGenere.length;i++){ typeForGenere[i]=typeForGenere[i].toUpperCase(); } }
        ResultSet table =metaData.getTables(this.databasename, "public", null, typeForGenere);
        List<String> lTab=new ArrayList<String>();
        while (table.next()){
            lTab.add( table.getString("TABLE_NAME") );
        }
        String[] tablenames=new String[lTab.toArray().length];
        tablenames=lTab.toArray(tablenames);
        table.close();
        return tablenames;
    }
    // * ou name of table 
    public void createControllerOfDataBase(Connection connection,String nametable)throws Exception{
        DatabaseMetaData metaData=connection.getMetaData();
        String [] nametables=new String[1];
        nametables[0]=nametable;
        if(nametable.compareTo("*")==0){
            nametables=getTableNames(metaData, new String[]{"Table"});
        }
        TableInfo tabinfo=null;
        String pkname="";
        for(int i=0;i<nametables.length;i++){
            tabinfo=getTableInfo(metaData, nametables[i]);
            pkname=getFirstPkname(tabinfo);
            createclassbytablename(nametables[i],nametables[i],pkname,metaData);
        }
    }
    public String createQueryForBestList(TableInfo tabinfo,DatabaseMetaData metaData)throws Exception{
        String query1="select ";
        String query2=" from "+tabinfo.getTablename();
        TableInfo tabinfTemp=null;
        for(int i=0;i<tabinfo.lstcol.size();i++){
            // String name;
            // boolean estPK;
            // boolean estFK;
            // String tabOriginFk;
            // String colFromOrigin;
            if(tabinfo.getLstcol().get(i).isEstFK()==true){ //si FK
                tabinfTemp=getTableInfo( metaData,tabinfo.getLstcol().get(i).getTabOriginFk());
                //on ajoute une apres le "from table " jointure par FK_name du_table = FK_origin_name (real PK)
                query2+=" join "+tabinfTemp.getTablename()+" on "+tabinfTemp.getTablename()+"."+tabinfo.getLstcol().get(i).getColFromOrigin()+"="+tabinfo.getTablename()+"."+tabinfo.getLstcol().get(i).getName()+" ";
                //et on affiche les colonne de la table origin du FK
                for(int j=0;j<tabinfTemp.lstcol.size();j++){
                    query1+= tabinfTemp.getTablename()+"."+tabinfTemp.getLstcol().get(j).getName()+",";
                }
            }else{
                query1+= tabinfo.getTablename()+"."+tabinfo.getLstcol().get(i).getName()+",";
            }
        }
        if(query1.substring(query1.length()-1).compareTo(",")==0){ query1=query1.substring(0,query1.length()-1); }
        return (query1+query2);
    }



}