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

public class GenereView
{ 
    String pathViewVariable;
    String typeView;
    String methodhttp;
    String host;
    String port;
    String pathToProject;
    String databasename;
    public GenereView(){}    

    
    public GenereView(String databasename,String pathViewVariable, String typeView, String methodhttp, String host, String port,String pathToProject) {
        this.databasename = databasename;
        this.pathViewVariable = pathViewVariable;
        this.typeView = typeView;
        this.methodhttp = methodhttp;
        this.host = host;
        this.port = port;
        this.pathToProject = pathToProject;
    }

    public String getDatabasename() {
        return databasename;
    }
    public void setDatabasename(String databasename) {
        this.databasename = databasename;
    }
    public String getPathViewVariable() {
        return pathViewVariable;
    }
    public void setPathViewVariable(String pathViewVariable) {
        this.pathViewVariable = pathViewVariable;
    }
    public String getTypeView() {
        return typeView;
    }
    public void setTypeView(String typeView) {
        this.typeView = typeView;
    }
    public String getMethodhttp() {
        return methodhttp;
    }
    public void setMethodhttp(String methodhttp) {
        this.methodhttp = methodhttp;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getPathToProject() {
        return pathToProject;
    }
    public void setPathToProject(String pathToProject) {
        this.pathToProject = pathToProject;
    }


    public static String getTypeName(int sqlType) {
        String nametype = "";
        switch (sqlType) {
            case Types.INTEGER:
                nametype = "int";
                break;
            case Types.SMALLINT:
                nametype = "short";
                break;
            case Types.BIGINT:
                nametype = "long";
                break;
            case Types.NUMERIC:
                nametype = "BigDecimal";
                break;
            case Types.REAL:
                nametype = "float";
                break;
            case Types.DOUBLE:
            case Types.FLOAT:
                nametype = "double";
                break;
            case Types.CHAR:
            case Types.NCHAR:
            case Types.VARCHAR:
            case Types.NVARCHAR:
            case Types.LONGVARCHAR:
            case Types.LONGNVARCHAR:
            case Types.CLOB:
            case Types.NCLOB:
                nametype = "String";
                break;
            case Types.DATE:
                nametype="Date";
                break;
            case Types.TIME:
                nametype = "Time";
                break;
            case Types.TIMESTAMP:
                nametype = "LocalDateTime";
                break;
            case Types.BOOLEAN:
            case Types.BIT:
                nametype = "boolean";
                break;
            case Types.BINARY:
            case Types.VARBINARY:
            case Types.LONGVARBINARY:
            case Types.BLOB:
                nametype = "byte[]";
                break;
            default:
                nametype = "<Non géré>";
                break;
        }
        return nametype; 
    }
    public List<String> getPrimaryKeys(DatabaseMetaData metaData,String nametable)throws Exception{
        ResultSet pkeys= metaData.getPrimaryKeys(null, null, nametable);
        List<String> pkname=new ArrayList<String>();//colonnename //tablename //originname
        while (pkeys.next()) {
            pkname.add(pkeys.getString("COLUMN_NAME"));
            //pkeys.getInt("DATA_TYPE")
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
            col.setName(columnsResultSet.getString("COLUMN_NAME"));// getTypeName(int sqlType)
            col.setTypecol( getTypeName(columnsResultSet.getInt("DATA_TYPE")) );
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

    public DetailView getDetailViewrByTypeview()throws Exception{
        String jsonFilePath = this.pathViewVariable;
        try{
            FileReader reader = new FileReader(jsonFilePath);
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            // ex Récupérer la partie "angular" du JSON
            JsonObject dotnetObject = jsonObject.getAsJsonObject(this.typeView);
            Gson gson = new Gson();
            DetailView detailView = gson.fromJson(dotnetObject, DetailView.class);
            reader.close();
            return detailView;
        }catch(IOException io){throw io;
        }catch(Exception ex){throw ex; }
    }


    //String tablename;
    //List<ColumnInfo> lstcol;
        // String name;
        // boolean estPK;
        // boolean estFK;
        // String tabOriginFk;
        // String colFromOrigin;
    public String getStringIn(String contenu,String strdebut,String strfin){
        //ex = "<1>koko<2>" ---> "koko" 
        int debutIndex = contenu.indexOf(strdebut);
        int finIndex = contenu.indexOf(strfin);
        if(debutIndex==-1 || finIndex==-1){ return ""; }
        String thestr=contenu.substring(debutIndex+strdebut.length(),finIndex);
        return thestr;
    }
    public String getReplaceInBaliseWithBaliseByStr(String contenu,String balise1,String balise2,String replace){
        int index1=contenu.indexOf(balise1);
        int index2=contenu.indexOf(balise2)+balise2.length();
        if(index1==-1 || index2==-1){ return contenu; }//satria mety tsy nisy le balise
        String rep="";
        if(index1>0){ rep=contenu.substring(0, index1)+replace; }
        else { rep=replace; }
        if(index2<contenu.length()){ rep+=contenu.substring(index2); }
        return rep;
    }
    //rehefa -1 le izy de tsy atao fotsiny
    public String toUpperCaseFirst(String str){ return str.toUpperCase().substring(0,1)+str.substring(1,str.length()); } 
    public String toLowerCaseFirst(String str){ return str.toLowerCase().substring(0,1)+str.substring(1,str.length()); }

    public String getTemplate(String pathtemplate)throws Exception{
        File fichier =  new File(pathtemplate);
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
    public String getCreateTemplate(String template,DetailView detailView)throws Exception{
        String contenu=template+"";
        Field[] fields=detailView.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            contenu=contenu.replaceAll( "#"+fields[i].getName()+"#", fields[i].get(detailView).toString());
            fields[i].setAccessible(false);
        }
        return contenu;
    }
    public String getFirstPkname(TableInfo tableinfo)throws Exception{
        for(int i=0;i<tableinfo.lstcol.size();i++){  if(tableinfo.lstcol.get(i).isEstPK()==true){ return tableinfo.lstcol.get(i).getName(); } 
        }throw new Exception("primary key obligatoire pour table "+tableinfo.getTablename()); 
    }

    public String getColonneForLabel(TableInfo tableinfo)throws Exception{
        List<ColumnInfo> lcols=tableinfo.getLstcol();
        String collab="";
        String containsname=null; boolean cnFirst=false;
        String firstString=null; boolean fsFirst=false;
        String pk=null; boolean pkFirst=false;
        for(int i=0;i<lcols.size();i++){
            collab=lcols.get(i).getName();
            if( (collab.contains("name")==true || collab.contains("nom")==true || collab.contains("label")==true ) && cnFirst==false ){ containsname=collab+""; cnFirst=true; }
            else if( lcols.get(i).getTypecol().compareToIgnoreCase("String")==0 && fsFirst==false ){ firstString=collab+""; fsFirst=true; }
            else if( lcols.get(i).isEstPK()==true && pkFirst==false ){ pk=collab+""; pkFirst=true; }
        }
        if(containsname!=null){ return containsname; }
        else if(firstString!=null){ return firstString; }
        else if(pk!=null){ return pk;  }
        else{ throw new Exception("cle primaire obligatoire "+tableinfo.getTablename()); }
    }

    public String getTypeHtmlInputConvenable(ColumnInfo columnInfo,DetailView detailView){//Date Time LocalDateTime boolean
        if(columnInfo.getTypecol().compareToIgnoreCase("Date")==0){ return detailView.getTypedate(); }
        else if(columnInfo.getTypecol().compareToIgnoreCase("LocalDateTime")==0){ return detailView.getTypedatetime(); }
        else if(columnInfo.getTypecol().compareToIgnoreCase("Time")==0){ return detailView.getTypetime(); }
        else { return detailView.getTypetext(); }
    }

    public List<String> getColumnNamesOfResultQueryDetailed(TableInfo tabinfo,DatabaseMetaData metaData)throws Exception{
        TableInfo tabinfTemp=null;
        List<String> lstcol=new ArrayList<String>();
        for(int i=0;i<tabinfo.lstcol.size();i++){
            if(tabinfo.getLstcol().get(i).isEstFK()==true){ //si FK
                tabinfTemp=getTableInfo( metaData,tabinfo.getLstcol().get(i).getTabOriginFk());
                for(int j=0;j<tabinfTemp.lstcol.size();j++){
                    lstcol.add(tabinfTemp.getLstcol().get(j).getName());
                }
            }else{
                lstcol.add(tabinfo.getLstcol().get(i).getName());
            }
        }
        return lstcol;
    }
    //getTableInfo( DatabaseMetaData metaData,String nametable)
    public String createViewHtmlAngular(DatabaseMetaData metaData,String nametable,DetailView detailView,String pathtemplatehtml)throws Exception{
        TableInfo tableinfo=getTableInfo(metaData, nametable);
        String template=getCreateTemplate(getTemplate(pathtemplatehtml),detailView);
        String entityname=tableinfo.getTablename();
        String entitynameUp=toUpperCaseFirst(entityname);
        template=template.replaceAll("<<entityname>>", entityname).replaceAll("<<Entityname>>", entitynameUp);
        String pkname=getFirstPkname(tableinfo);
        template=template.replaceAll("<<namepk>>", pkname);

        //saveform
        String saveformtemple=getStringIn(template, "<<saveForm>>", "<</saveForm>>");
        String pkchamptempl=getStringIn(saveformtemple, "<<pkchamp>>", "<</pkchamp>>");
        String selecttemple=getStringIn(saveformtemple,"<<selecttempl>>", "<</selecttempl>>");
        String optiontemple=getStringIn(saveformtemple, "<<optiontempl>>", "<</optiontempl>>");
        String inputtemple=getStringIn(saveformtemple,"<<inputtempl>>", "<</inputtempl>>");
        //updateform
        String updateformtemple=getStringIn(template, "<<updateForm>>", "<</updateForm>>");
        String pkchamptempl2=getStringIn(updateformtemple, "<<pkchamp>>", "<</pkchamp>>");
        String selecttemple2=getStringIn(updateformtemple,"<<selecttempl>>", "<</selecttempl>>");
        String optiontemple2=getStringIn(updateformtemple, "<<optiontempl>>", "<</optiontempl>>");
        String inputtemple2=getStringIn(updateformtemple,"<<inputtempl>>", "<</inputtempl>>");
        //listetable
        String listetable=getStringIn(template, "<<listetable>>", "<</listetable>>");
        String thtemple=getStringIn(listetable,"<<head-table-templ>>","<</head-table-templ>>");
        String tdtemple=getStringIn(listetable,"<<column-table-templ>>","<</column-table-templ>>");
        String thcontains="";
        String tdcontains="";

        String inputscontainssv="";
        String inputscontainsup="";

        //pkchamp=pkchamp.replaceAll("<<typepk>>", "hidden").replaceAll("<<valuepk>>", "0");
        //<<inputs>>
        List<ColumnInfo> lstcl=tableinfo.getLstcol();
        ColumnInfo coltmp=null;
        String tmpstr="";
        String containstmp="";
        TableInfo tableInfoFk=null;
        //Creer les champs save et update
        for(int i=0;i<lstcl.size();i++){
            coltmp=lstcl.get(i);
            //<<field>>:<<value>>
            //<<fieldtemple>><<field>>:<<value>><</fieldtemple>>
            //raha pk,
            if(coltmp.isEstPK()==true){
                inputscontainssv+=pkchamptempl.replaceAll("<<typepk>>", "hidden").replaceAll("<<valuepk>>", "0").replaceAll("<<a_namepk>>", coltmp.getName())+"\n";
                inputscontainsup+=pkchamptempl2.replaceAll("<<typepk>>", "hidden").replaceAll("<<a_namepk>>", coltmp.getName())+"\n"; //efa vo remplace tetsy ambony ny entity
                ////23//System.out.println(inputscontainsup);
            }else if(coltmp.isEstFK()==true){
                tmpstr=toUpperCaseFirst(coltmp.getTabOriginFk());
                tableInfoFk=getTableInfo(metaData, coltmp.getTabOriginFk()); //se qu'on affiche comme label sur l'option du selection
                //save
                containstmp="";
                containstmp=selecttemple.replaceAll("<<namelabel>>", coltmp.getTabOriginFk()).replaceAll("<<Namelabel>>", tmpstr).replaceAll("<<name-select>>",coltmp.getName()).replaceAll("<<field-entity>>", coltmp.getName());
                containstmp=this.getReplaceInBaliseWithBaliseByStr(containstmp, "<<optiontempl>>","<</optiontempl>>", optiontemple.replaceAll("<<data-select>>",coltmp.getTabOriginFk()).replaceAll("<<field-value-option>>",coltmp.getColFromOrigin()).replaceAll("<<label-option>>", getColonneForLabel(tableInfoFk)));//remplace les contenu du balise ainsi que les balise par l'option
                inputscontainssv+=containstmp+"\n";
                //update
                containstmp="";
                containstmp=selecttemple2.replaceAll("<<namelabel>>", coltmp.getTabOriginFk()).replaceAll("<<Namelabel>>", tmpstr).replaceAll("<<name-select>>",coltmp.getName()).replaceAll("<<field-entity>>", coltmp.getName());
                containstmp=this.getReplaceInBaliseWithBaliseByStr(containstmp,"<<optiontempl>>","<</optiontempl>>", optiontemple2.replaceAll("<<data-select>>",coltmp.getTabOriginFk()).replaceAll("<<field-value-option>>",coltmp.getColFromOrigin()).replaceAll("<<label-option>>", getColonneForLabel(tableInfoFk)) );
                inputscontainsup+=containstmp+"\n";
            }else{
                if(coltmp.getTypecol().compareToIgnoreCase("boolean")!=0){
                    tmpstr=getTypeHtmlInputConvenable(coltmp,detailView); //type html
                    inputscontainssv+=inputtemple.replaceAll("<<namelabel>>", coltmp.getName()).replaceAll("<<Namelabel>>", toUpperCaseFirst(coltmp.getName()) ).replaceAll("<<typeinput>>", tmpstr).replaceAll("<<name-input>>", coltmp.getName())+"\n";
                    inputscontainsup+=inputtemple2.replaceAll("<<namelabel>>", coltmp.getName()).replaceAll("<<Namelabel>>", toUpperCaseFirst(coltmp.getName()) ).replaceAll("<<typeinput>>", tmpstr).replaceAll("<<name-input>>", coltmp.getName())+"\n";
                    
                }else{ //raha boolean de selection
                    tmpstr=toUpperCaseFirst(coltmp.getName());
                    //save
                    containstmp="";
                    containstmp=selecttemple.replaceAll("<<namelabel>>", coltmp.getName()).replaceAll("<<Namelabel>>", tmpstr).replaceAll("<<name-select>>",coltmp.getName());
                    containstmp=this.getReplaceInBaliseWithBaliseByStr(containstmp, "<<optiontempl>>","<</optiontempl>>","<option [value]=\"true\">true</option>\n<option [value]=\"false\">false</option>");
                    inputscontainssv+=containstmp+"\n";
                    //update
                    containstmp="";
                    containstmp=selecttemple2.replaceAll("<<namelabel>>", coltmp.getName()).replaceAll("<<Namelabel>>", tmpstr).replaceAll("<<name-select>>",coltmp.getName());
                    containstmp=this.getReplaceInBaliseWithBaliseByStr(containstmp, "<<optiontempl>>","<</optiontempl>>","<option [value]=\"true\">true</option>\n<option [value]=\"false\">false</option>");
                    inputscontainsup+=containstmp+"\n";
                }
            }
        }
        saveformtemple=this.getReplaceInBaliseWithBaliseByStr(saveformtemple, "<<inputs>>", "<</inputs>>", inputscontainssv);
        updateformtemple=this.getReplaceInBaliseWithBaliseByStr(updateformtemple, "<<inputs>>", "<</inputs>>", inputscontainsup);
        
        //23//System.out.println(updateformtemple);
        //Liste by table
        List<String> lstScol=this.getColumnNamesOfResultQueryDetailed(tableinfo,metaData);
        for(int i=0;i<lstScol.size();i++){
            thcontains+=thtemple.replaceAll("<<head-table>>",lstScol.get(i))+"\n";
            tdcontains+=tdtemple.replaceAll("<<field-column-value>>", lstScol.get(i))+"\n";
        }
        listetable=this.getReplaceInBaliseWithBaliseByStr(listetable, "<<head-table-templ>>", "<</head-table-templ>>", thcontains);
        listetable=this.getReplaceInBaliseWithBaliseByStr(listetable, "<<column-table-templ>>", "<</column-table-templ>>", tdcontains);
        //soloina ny entre reo : <<saveForm>> , <<updateForm>> , <<listetable>>
        template=this.getReplaceInBaliseWithBaliseByStr(template, "<<saveForm>>", "<</saveForm>>", saveformtemple);
        template=this.getReplaceInBaliseWithBaliseByStr(template, "<<updateForm>>", "<</updateForm>>", updateformtemple);
        template=this.getReplaceInBaliseWithBaliseByStr(template, "<<listetable>>", "<</listetable>>", listetable);
        return template;

    }
    public String createComponentTsAngular(TableInfo tableInfo,DetailView detailView,String pathtemplateComponentTs)throws Exception{
        String template=getCreateTemplate(getTemplate(pathtemplateComponentTs),detailView);
        String nametable=tableInfo.getTablename();
        String nametabUp=toUpperCaseFirst(nametable);
        String namepk=getFirstPkname(tableInfo);

        //entitycreate
        //<<fieldtemple>><<field>>:<<value>><</fieldtemple>>
        String enttcreatTempl=getStringIn(template, "<<fieldtemple>>", "<</fieldtemple>>");
        String enttcreatcontains="";
        
        String templeinstancssentity=getStringIn(template, "<<instance-sousentityname>>", "<</instance-sousentityname>>");
        String instssContains="";
        String templReadsousentity=getStringIn(template, "<<templ-read-sousentity>>", "<</templ-read-sousentity>>");
        templReadsousentity=templReadsousentity.replaceAll("<<http>>", this.methodhttp).replaceAll("<<host>>", this.host).replaceAll("<<port>>", this.port);
        templReadsousentity=templReadsousentity.replaceAll("<<entityname>>","<<sousentityname>>").replaceAll("<<Entityname>>", "<<Sousentityname>>");
        String rdssContains="";
        String templeSetsousentity=getStringIn(template,"<<templ-method-setsousentity>>", "<</templ-method-setsousentity>>");
        String setssContains="";
        
        template=template.replaceAll("<<pagename>>",nametable).replaceAll("<<Pagename>>", nametabUp);
        template=template.replaceAll("<<entityname>>",nametable).replaceAll("<<Entityname>>", nametabUp);
        template=template.replaceAll("<<namepk>>",namepk);
        template=template.replaceAll("<<http>>", this.methodhttp).replaceAll("<<host>>", this.host).replaceAll("<<port>>", this.port);

        String importtemple=getStringIn(template, "<<imports>>", "<</imports>>");
        String importcontains="";
        String importcompcontains="";
        String[][] libsm=detailView.getImportcomponentts();
        String[] importcomp= detailView.getImportstocomponent();
        if(libsm!=null){
            for(int i=0;i<libsm.length;i++){
                if(libsm[i].length>=2){
                    importcontains+=importtemple.replaceAll("<<lib_son>>", libsm[i][0]).replaceAll("<<lib_mom>>", libsm[i][1])+"\n";
                }
            }
        }
        if(importcomp!=null){
            for(int i=0;i<importcomp.length;i++){
                importcompcontains+=importcomp[i]+",";
            }
            if(importcompcontains.substring(importcompcontains.length()-1).compareTo(",")==0){ importcompcontains=importcompcontains.substring(0, importcompcontains.length()-1); }
        }
        template=this.getReplaceInBaliseWithBaliseByStr(template,"<<imports>>","<</imports>>", importcontains);
        template=template.replaceAll("<<importstocomponent>>", importcompcontains);
        List<ColumnInfo> lcol=tableInfo.getLstcol();
        ColumnInfo col=null;
        String upcaseSs="";
        for(int i=0;i<lcol.size();i++){
            col=lcol.get(i);
            if(col.isEstFK()==true){
                upcaseSs= toUpperCaseFirst(col.getTabOriginFk());
                instssContains+=templeinstancssentity.replaceAll("<<sousentityname>>",col.getTabOriginFk())+"\n";
                rdssContains+=templReadsousentity.replaceAll("<<Sousentityname>>",upcaseSs).replaceAll("<<sousentityname>>", col.getTabOriginFk())+"\n";
                setssContains+=templeSetsousentity.replaceAll("<<Sousentityname>>",upcaseSs)+"\n";
                enttcreatcontains+=enttcreatTempl.replaceAll("<<field>>", col.getName()).replaceAll("<<value>>", "null")+",";
            }else if(col.isEstPK()==true){
                enttcreatcontains+=enttcreatTempl.replaceAll("<<field>>", col.getName()).replaceAll("<<value>>", "\'0\'")+",";
            }else{
                enttcreatcontains+=enttcreatTempl.replaceAll("<<field>>", col.getName()).replaceAll("<<value>>", "null")+",";
            }
        }
        enttcreatcontains=deletelastchar(enttcreatcontains, ',');
        template=this.getReplaceInBaliseWithBaliseByStr(template, "<<fieldtemple>>", "<</fieldtemple>>", enttcreatcontains);
        template=this.getReplaceInBaliseWithBaliseByStr(template,"<<instance-sousentityname>>","<</instance-sousentityname>>", instssContains);
        template=this.getReplaceInBaliseWithBaliseByStr(template,"<<templ-read-sousentity>>","<</templ-read-sousentity>>", rdssContains);
        template=this.getReplaceInBaliseWithBaliseByStr(template,"<<templ-method-setsousentity>>","<</templ-method-setsousentity>>", setssContains);
        template=this.getReplaceInBaliseWithBaliseByStr(template,"<<templ-method-setsousentity02>>","<</templ-method-setsousentity02>>", setssContains);
        return template;
    }

    public String createComponentSpecTs(TableInfo tableInfo,DetailView detailView,String pathtemplateComponentSpecTs)throws Exception{
        String template=getCreateTemplate(getTemplate(pathtemplateComponentSpecTs),detailView);
        String nametable=tableInfo.getTablename();
        String nametabUp=toUpperCaseFirst(nametable);

        template=template.replaceAll("<<pagename>>",nametable).replaceAll("<<Pagename>>", nametabUp);

        String importtemple=getStringIn(template, "<<imports>>", "<</imports>>");
        String importcontains="";
        String[][] libsm=detailView.getImportcomponentspects();
        if(libsm!=null){
            for(int i=0;i<libsm.length;i++){
                if(libsm[i].length>=2){
                    importcontains+=importtemple.replaceAll("<<lib_son>>", libsm[i][0]).replaceAll("<<lib_mom>>", libsm[i][1])+"\n";
                }
            }
        }
        template=this.getReplaceInBaliseWithBaliseByStr(template,"<<imports>>","<</imports>>", importcontains);
        return template;
    }
    public String createComponentCss(String pathtemplateComponentCss,DetailView detailView)throws Exception{
        String template=getCreateTemplate(getTemplate(pathtemplateComponentCss),detailView);
        return template;
    }

    // public void createDossierIfNotExiste(DatabaseMetaData metaData,String tablename)throws Exception{
    //     String code=this.getCodeStringClassByTablename(metaData, tablename);
    //     if(this.topath.substring(topath.length()-1).compareTo("/")!=0){ this.topath+="/"; }
    //     File fichier = new File(this.topath+toUpperCaseFirst(tablename)+"."+this.extension);
    //     if (!fichier.exists()) {
    //         fichier.createNewFile();
    //     }
    //     FileWriter fileWriter = new FileWriter(fichier);
    //     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    //     bufferedWriter.write(code);
    //     bufferedWriter.close();
    //     fileWriter.close();
    // }
    public void createFileIfNotExistWriteContains(String pathtofile,String namefile,String contenu)throws Exception{
        String path=pathtofile;
        if(path.substring(path.length()-1).compareTo("/")!=0){ path+="/"; }
        path=path+namefile;
        //23//System.out.println(path);
        File fichier = new File(path);
        
        if (!fichier.exists()) {
            fichier.createNewFile();
        }  
        FileWriter fileWriter = new FileWriter(fichier);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(contenu);
        bufferedWriter.close();
        fileWriter.close();
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
    public String deletelastchar(String str,char c){
        String p=str+"";
        if(str.isEmpty()==false){
            if(p.substring(p.length()-1).compareTo(String.valueOf(c))==0){ 
                p=p.substring(0,p.length()-1); 
            }
        }
        return p;
    }
    public void createDossierIfNotExiste(String path,String dossiername)throws Exception{
        if(path.substring(path.length()-1).compareTo("/")!=0){ path+="/"; }
        File fichier = new File(path+dossiername);
        if (!fichier.exists()) {
            fichier.mkdir();
        }
    }
    public void createpageAngular(DatabaseMetaData metaData,String nametable,DetailView detailView,String pathtemplatehtml,String pathtemplateComponentTs,String pathtemplateComponentSpecTs,String pathtemplatecompocss)throws Exception{
        TableInfo tableInfo=getTableInfo(metaData, nametable);
        String componentHtml=createViewHtmlAngular(metaData, nametable, detailView, pathtemplatehtml);
        String componentTs=createComponentTsAngular(tableInfo, detailView, pathtemplateComponentTs);
        String componentSpecTs=createComponentSpecTs(tableInfo, detailView, pathtemplateComponentSpecTs);
        String componentcss=createComponentCss(pathtemplatecompocss,detailView);
        //creer le dossier page dans le repertoir du projet
        createFolderIfNotExiste(deletebarLast(pathToProject));
        createDossierIfNotExiste(pathToProject,nametable);
        String pathDossier=""; //path pour mettre la page
        if(pathToProject.substring(pathToProject.length()-1).compareTo("/")!=0){ pathDossier=pathToProject+"/"+nametable; }
        else{ pathDossier=pathToProject+nametable; }
        //---- -page.component.ts
        createFileIfNotExistWriteContains(pathDossier+"/",nametable+"."+"component.ts",componentTs);
        //-----page.component.spec.ts
        createFileIfNotExistWriteContains(pathDossier+"/",nametable+"."+"component.spec.ts",componentSpecTs);
        //-----page.component.html
        createFileIfNotExistWriteContains(pathDossier+"/",nametable+"."+"component.html",componentHtml);
        //-----page.component.css
        createFileIfNotExistWriteContains(pathDossier+"/",nametable+"."+"component.css",componentcss);
    }

    public String[] getTableNames(DatabaseMetaData metaData ,String[] typeForGenere)throws Exception{//[0]=tablename,[1]=tabletype,[2]=tableschem
        if(typeForGenere==null){
            typeForGenere=new String[1];
            typeForGenere[0]="TABLE";
        }else{ for(int i=0;i<typeForGenere.length;i++){ typeForGenere[i]=typeForGenere[i].toUpperCase(); } }
        ResultSet table =metaData.getTables(this.databasename, "public", null, typeForGenere);
        List<String> lTab=new ArrayList<String>();
        while (table.next()) {
            lTab.add( table.getString("TABLE_NAME") );
         }
        String[] tablenames=new String[lTab.toArray().length];
        tablenames=lTab.toArray(tablenames);
        table.close();
        return tablenames;
    }
//   public String createComponentCss(String pathtemplateComponentCss,DetailView detailView)throws Exception{
//     String template=getCreateTemplate(getTemplate(pathtemplateComponentCss),detailView);
//     return template;
// }
//-------------APP.COMPONENT
    //app.component.html et app.routes.ts
    public String[] getCreate_AppComponentHtml_AppRoutesTs(String[] tabnames,String pathtemplAppComponentHtml,String pathtemplAppRoutesTs,DetailView detailView)throws Exception{
        String template=getCreateTemplate(getTemplate(pathtemplAppComponentHtml),detailView);
        String template2=getCreateTemplate(getTemplate(pathtemplAppRoutesTs),detailView);
        //<<li-temple>><li><a href="<<pagename>>"><<Entityname>></a></li><<li-temple>>
        String li_temple=getStringIn(template, "<<li-temple>>", "<</li-temple>>");
        String li_contains="";
        //<<templ-importpage>>import { <<Pagename>>Component } from './<<pagename>>.component'; <</templ-importpage>>
        String importPageTempl=getStringIn(template2, "<<templ-importpage>>","<</templ-importpage>>");
        String imprtPgContains="";
        //<<templ-routepage>>    { path: '<<pagename>>', component: <<Pagename>>Component },<</templ-routepage>>
        String routpgTempl=getStringIn(template2, "<<templ-routepage>>", "<</templ-routepage>>");
        String routpgContains="";

        String upTmp="";
        for(int i=0;i<tabnames.length;i++){
            upTmp=toUpperCaseFirst(tabnames[i]);
            li_contains+=li_temple.replaceAll("<<pagename>>", tabnames[i]).replaceAll("<<Entityname>>", upTmp)+"\n";
            imprtPgContains+=importPageTempl.replaceAll("<<Pagename>>", upTmp).replaceAll("<<pagename>>", tabnames[i])+"\n";
            routpgContains+=routpgTempl.replaceAll("<<Pagename>>", upTmp).replaceAll("<<pagename>>", tabnames[i])+"\n";
        }
        template=this.getReplaceInBaliseWithBaliseByStr(template, "<<li-temple>>", "<</li-temple>>", li_contains);
        template2=this.getReplaceInBaliseWithBaliseByStr(template2,"<<templ-importpage>>","<</templ-importpage>>", imprtPgContains);
        template2=this.getReplaceInBaliseWithBaliseByStr(template2,"<<templ-routepage>>","<</templ-routepage>>", routpgContains);
        
        String importtemple=getStringIn(template2, "<<imports>>", "<</imports>>");
        String importcontains="";
        String[][] libsm=detailView.getImportapproutes();
        
        if(libsm!=null){
            for(int i=0;i<libsm.length;i++){
                if(libsm[i].length>=2){
                    importcontains+=importtemple.replaceAll("<<lib_son>>", libsm[i][0]).replaceAll("<<lib_mom>>", libsm[i][1])+"\n";
                }
            }
        }
        template2=this.getReplaceInBaliseWithBaliseByStr(template2,"<<imports>>","<</imports>>", importcontains);
        
        String[] cpTs_rtTs=new String[2];
        cpTs_rtTs[0]=template;
        cpTs_rtTs[1]=template2;
        return cpTs_rtTs;
    }
    //app.component.ts
    public String getCreateAppComponentTs(String pathtemplAppComponentTs,DetailView detailView)throws Exception{
        String template=getCreateTemplate(getTemplate(pathtemplAppComponentTs),detailView);
        template=template.replaceAll("<<nbBoolValue>>", "false");
        return template;
    }

    public void createAppComponentHtml_AppComponentTs_AppRoutesTs(DatabaseMetaData metaData,String[] nametables,DetailView detailView,String pathtemplAppComponentHtml,String pathtemplAppRoutesTs,String pathtemplAppComponentTs)throws Exception{
        String[] apphtml_rout= this.getCreate_AppComponentHtml_AppRoutesTs(nametables, pathtemplAppComponentHtml, pathtemplAppRoutesTs, detailView);
        String appcomTs=this.getCreateAppComponentTs(pathtemplAppComponentTs,detailView);
        //creer le dossier page dans le repertoir du projet
        createDossierIfNotExiste(this.pathToProject,"app");
        String pathDossier=this.pathToProject; //path pour mettre la page
        pathDossier=deletebarLast(pathDossier);
        //-----app.component.html
        createFileIfNotExistWriteContains(pathDossier+"/","app."+"component.html",apphtml_rout[0]);
        //-----app.routes.ts
        createFileIfNotExistWriteContains(pathDossier+"/","app.routes.ts",apphtml_rout[1]);
        //---- -app.component.ts
        createFileIfNotExistWriteContains(pathDossier+"/","app.component.ts",appcomTs);
    }

    public void createPageAngularAndtheAppConfig(
    Connection connection  ,
    String tablename,
    String pathtemplatehtml,
    String pathtemplateComponentTs,
    String pathtemplateComponentSpecTs,
    String pathtemplatecompocss,  
    
    String pathtemplAppComponentHtml,
    String pathtemplAppRoutesTs,
    String pathtemplAppComponentTs,
    String[] typeforgenere
    )throws Exception{
        DatabaseMetaData databaseMetaData=connection.getMetaData();
        String[] tabnames=null;
        if(tablename.compareTo("*")==0){
            tabnames=getTableNames(databaseMetaData,typeforgenere);
        }else{
            tabnames=new String[1];
            tabnames[0]=tablename;
        }
        DetailView detailView=getDetailViewrByTypeview();
        this.createAppComponentHtml_AppComponentTs_AppRoutesTs(databaseMetaData, tabnames, detailView, pathtemplAppComponentHtml, pathtemplAppRoutesTs, pathtemplAppComponentTs);
        for(int i=0;i<tabnames.length;i++){
            this.createpageAngular(databaseMetaData, tabnames[i], detailView, pathtemplatehtml, pathtemplateComponentTs, pathtemplateComponentSpecTs, pathtemplatecompocss);
        }

    }
    public void test(Connection conn,String nametable) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet columnsResultSet = metaData.getColumns(null, null, nametable, null);
        while (columnsResultSet.next()) {
            String columnName = columnsResultSet.getString("COLUMN_NAME");
            boolean isPrimaryKey = isPrimaryKey(metaData, nametable, columnName);
            boolean isForeignKey = isForeignKey(metaData, nametable, columnName);

            //23//System.out.println("Column: " + columnName);
            //23//System.out.println("Is Primary Key: " + isPrimaryKey);
            //23//System.out.println("Is Foreign Key: " + isForeignKey);

        }
        columnsResultSet.close();
    }


    private  boolean isPrimaryKey(DatabaseMetaData metaData, String tableName, String columnName) throws SQLException {
        ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName);
        while (primaryKeys.next()) {
            if (columnName.equals(primaryKeys.getString("COLUMN_NAME"))) {
                return true;
            }
        }
        primaryKeys.close();
        return false;
    }
    private  boolean isForeignKey(DatabaseMetaData metaData, String tableName, String columnName) throws SQLException {
        ResultSet importedKeys = metaData.getImportedKeys(null, null, tableName);
        while (importedKeys.next()) {
            if (columnName.equals(importedKeys.getString("FKCOLUMN_NAME"))) {
                //23//System.out.println("table origin fk:"+importedKeys.getString("PKTABLE_NAME"));//-------->table
                //23//System.out.println("origin pk:"+importedKeys.getString("PKCOLUMN_NAME"));//----> le tena izy
                //23//System.out.println("fk:"+importedKeys.getString("FKCOLUMN_NAME"));//----> le ny @ le vahiny
                return true;
            }
        }
        importedKeys.close();
        return false;
    }





}