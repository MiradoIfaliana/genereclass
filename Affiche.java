package main;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.Time;
import java.time.*;
import java.time.temporal.ChronoUnit;

import javax.swing.text.View;

import connect.*;
public class Affiche {
    public static void main(String[] args)throws Exception{
        // ////GENERATOR CLASS
        Connect connect=new Connect("./config.xml");
        Connection connection=connect.getConnection();
        // String []types={"Table","view"};
        // GenereClass genereClass=new GenereClass("cs", "./generateclasses34", "entite",types,connect.getDatabasename(),null,"./template/classe/Class.templ","./template/classe/classvariable.json");//ireo ihan no tena miasa aloha
        // //connection=new Connect().getConnectionMysql();
        // genereClass.createclassOfdatabase(connection);
        


        // GenereView genereview=new GenereView();
        // TableInfo tabinf=genereview.getTableInfo(connection.getMetaData(),"foreigntab");
        // tabinf.affiche();

        //genereview.test(connection,"foreigntab");
        
        //connection.close();

        //GENERATOR CONTROLLER
        // GenereController geController=new GenereController( "meuble","dotnet","./generatecontroller", "crudnet.Controllers","./template/controller/Controller.templ","./template/controller/controllervariable.json","crudnet.Models");
        // //DetailController detailController=geController.getDetailControllerByTypeController();
        // geController.createclassbytablename("matiereprix","matiereprix","idmatiereprix",connection.getMetaData());
        // geController.createclassbytablename("matiere","matiere","idmatiere",connection.getMetaData());
        
        //detailController.affiche();
        ;
        // String query=geController.createQueryForBestList(geController.getTableInfo(connection.getMetaData(), "matiereprix"), connection.getMetaData());
        // System.out.println(query);

        // //GENERATOR VIEW 
        //  String tablename="*";
        // String pathtemplatehtml="./template/view/angular/component.html.templ";
        // String pathtemplateComponentTs="./template/view/angular/component.ts.templ";
        // String pathtemplateComponentSpecTs="./template/view/angular/component.spec.ts.templ";
        // String pathtemplatecompocss="./template/view/angular/component.css.templ";  
        
        // String pathtemplAppComponentHtml="./template/view/angular/app.component.html.templ";
        // String pathtemplAppRoutesTs="./template/view/angular/app.routes.ts.templ";
        // String pathtemplAppComponentTs="./template/view/angular/app.component.ts.templ";
        // String[] typeforgenere={"Table"};
        // GenereView genereView=new GenereView(connect.getDatabasename(),"./template/view/angular/viewAngVariable.json", "angular", "http", "localhost", "5031", "./generateview/");
        // DetailView detailView=genereView.getDetailViewrByTypeview();
        // //genereView.createpageAngular(connection.getMetaData(),"matiereprix",detailView,pathtemplatehtml,pathtemplateComponentTs,pathtemplateComponentSpecTs,pathtemplatecompocss);
        // //genereView.createAppComponentHtml_AppComponentTs_AppRoutesTs(connection.getMetaData(),new String[]{"matiere","matiereprix"},detailView,pathtemplAppComponentHtml,pathtemplAppRoutesTs,pathtemplAppComponentTs);
        // genereView.createPageAngularAndtheAppConfig(connection, tablename, pathtemplatehtml, pathtemplateComponentTs, pathtemplateComponentSpecTs, pathtemplatecompocss, pathtemplAppComponentHtml, pathtemplAppRoutesTs, pathtemplAppComponentTs, typeforgenere);
        // public void createPageAngularAndtheAppConfig(
        //     Connection connection  ,
        //     String tablename,
        //     String pathtemplatehtml,
        //     String pathtemplateComponentTs,
        //     String pathtemplateComponentSpecTs,
        //     String pathtemplatecompocss,  
            
        //     String pathtemplAppComponentHtml,
        //     String pathtemplAppRoutesTs,
        //     String pathtemplAppComponentTs,
        //     String[] typeforgenere
        //     ){
        
        GenereProject gnproject=new GenereProject();
        //gnproject.configByCmd("./config.xml");
        //gnproject.configByXml("./config.xml");
        //gnproject.configByCmdByXml("./config.xml");
        gnproject.configAndCreate(connection ,"./config.xml");
        
        //gnproject.afficheFields();
        connection.close();

        

    }
}
            // float left=0;
            // float right=100;
            // boolean goodright=false;
            // boolean arret=false;
            // float consomme=right;
            // float nombre=(float)13.1122;
            // System.out.println(nombre);
            // while(arret==false){
            //     System.out.println("consomme="+consomme);
            //     if(nombre<consomme){//tcoup < heurecoupure : nalaky tapaka <=> be consommation
            //         right=consomme;
            //         consomme=(right+left)/2;
            //         goodright=true;
            //     }else if(nombre>consomme){ //tcoup > heurecoupure : ela vo tapaka <=> kely consommation
            //         if(goodright==false){ 
            //             right=right+(right/2); 
            //             consomme=right;
            //         } //raha mbola tsy nahitana borne sup mihintsy (droite)
            //         else{
            //             left=consomme;
            //             consomme=(right+left)/2;
            //         }
            //     }else { 
            //         arret=true;
            //     }
            //     //if( Math.abs(nombre-consomme)<0.01 ){ arret=true; }
            // }
            // System.out.println("Reponse="+consomme);  

// CREATE TABLE exemple_tous_les_types_de_donnees (
//     id SERIAL PRIMARY KEY,
//     colonne_smallint SMALLINT,
//     colonne_integer INT,
//     colonne_bigint BIGINT,
//     colonne_decimal DECIMAL(10, 2),
//     colonne_numeric NUMERIC(10, 2),
//     colonne_real REAL,
//     colonne_double DOUBLE PRECISION,
//     colonne_smallserial SMALLSERIAL,
//     colonne_serial SERIAL,
//     colonne_bigserial BIGSERIAL,
//     colonne_text TEXT,
//     colonne_char CHAR(10),
//     colonne_varchar VARCHAR(255),
//     colonne_date DATE,
//     colonne_timestamp TIMESTAMP,
//     colonne_timestamptz TIMESTAMPTZ,
//     colonne_time TIME,
//     colonne_timetz TIMETZ,
//     colonne_interval INTERVAL,
//     colonne_boolean BOOLEAN,
//     colonne_enum ENUM('Valeur1', 'Valeur2', 'Valeur3'),
//     colonne_bytea BYTEA,
//     colonne_bit BIT(8),
//     colonne_varbit VARBIT(16),
//     colonne_uuid UUID,

