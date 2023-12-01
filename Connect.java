package connect;
import java.io.File;
import java.sql.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

public class Connect
{ 
    String pathconfigxml;
    String driver;
    String url;
    String user;
    String password;
    String databasename;
    public Connect(){
    }
    public Connect(String pathconfigxml){
        setPathconfigxml(pathconfigxml);
    }
    public String getPathconfigxml() {
        return pathconfigxml;
    }
    public void setPathconfigxml(String pathconfigxml) {
        this.pathconfigxml = pathconfigxml;
    }
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDatabasename() {
        return databasename;
    }
    public void setDatabasename(String databasename) {
        this.databasename = databasename;
    }


    public String getContentXml(String pathconfigxml,String tagname,int indexitem )throws Exception{
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
          File xmlFile = new File(pathconfigxml);
          Document document = builder.parse(xmlFile);
          Element rootElement= document.getDocumentElement();
          //----------------------------------------------------------------------------------recuperation des class annoter scope
          NodeList nodeList=rootElement.getElementsByTagName(tagname);
          Element element=(Element)nodeList.item(indexitem); //de le 1er satria iray ihany ny pathconfigxml-after-WEB-INF
          String content=element.getTextContent();
          if(content==null){ content=""; }
          return content;
    }
    public void config()throws Exception{
        if(pathconfigxml==null){ throw new Exception("path du configuration xml"); }
        driver=getContentXml(pathconfigxml, "driver", 0);
        url=getContentXml(pathconfigxml, "url", 0);
        user=getContentXml(pathconfigxml, "user", 0);
        password=getContentXml(pathconfigxml, "password", 0);
        databasename=getContentXml(pathconfigxml, "databasename", 0);
    }
    public Connection getConnection()throws Exception{
        config();
        Connection connection;
        Class.forName(driver);
        if(url.substring(url.length()-1,url.length()).compareToIgnoreCase("/")!=0){ url+="/"; }
        connection = DriverManager.getConnection(url+databasename, user, password);
        return connection;
    }







    
    // public Connection getConnectionPsql()throws Exception{
    //     Connection connection;
    //     //étape 1: charger la classe de driver
    //     Class.forName("org.postgresql.Driver");
    //     //étape 2: créer l'objet de connexion
    //     connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stock","postgres","motmirado");
    //     return connection;
    // } 
    // public Connection getConnectionMysql() throws Exception {
    //     Connection connection;
    //     Class.forName("com.mysql.cj.jdbc.Driver");
    //     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
    //     return connection;
    // }
    
}