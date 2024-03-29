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

public class DetailView {
    String typetext;
    String typedate;
    String typenumber;
    String typehidden;
    String typedatetime;
    String typetime;

    String endpointcreate;
    String endpointread;
    String endpointreaddetailed;
    String endpointreadbyid;
    String endpointupdate;
    String endpointdelete;

    String[][] importcomponentts;

    String[][] importcomponentspects;
    String[][] importapproutes;

    String[] importstocomponent;

    public DetailView() {
    }

    public String getTypetext() {
        return typetext;
    }
    public void setTypetext(String typetext) {
        this.typetext = typetext;
    }
    public String getTypedate() {
        return typedate;
    }
    public void setTypedate(String typedate) {
        this.typedate = typedate;
    }
    public String getTypenumber() {
        return typenumber;
    }
    public void setTypenumber(String typenumber) {
        this.typenumber = typenumber;
    }
    public String getTypehidden() {
        return typehidden;
    }
    public void setTypehidden(String typehidden) {
        this.typehidden = typehidden;
    }
    public String getTypedatetime() {
        return typedatetime;
    }
    public void setTypedatetime(String typedatetime) {
        this.typedatetime = typedatetime;
    }
    public String getTypetime() {
        return typetime;
    }
    public void setTypetime(String typetime) {
        this.typetime = typetime;
    }
    public String getEndpointcreate() {
        return endpointcreate;
    }
    public void setEndpointcreate(String endpointcreate) {
        this.endpointcreate = endpointcreate;
    }
    public String getEndpointread() {
        return endpointread;
    }
    public void setEndpointread(String endpointread) {
        this.endpointread = endpointread;
    }
    public String getEndpointreaddetailed() {
        return endpointreaddetailed;
    }
    public void setEndpointreaddetailed(String endpointreaddetailed) {
        this.endpointreaddetailed = endpointreaddetailed;
    }
    public String getEndpointreadbyid() {
        return endpointreadbyid;
    }
    public void setEndpointreadbyid(String endpointreadbyid) {
        this.endpointreadbyid = endpointreadbyid;
    }
    public String getEndpointupdate() {
        return endpointupdate;
    }
    public void setEndpointupdate(String endpointupdate) {
        this.endpointupdate = endpointupdate;
    }
    public String getEndpointdelete() {
        return endpointdelete;
    }
    public void setEndpointdelete(String endpointdelete) {
        this.endpointdelete = endpointdelete;
    }

    public String[][] getImportcomponentts() {
        return importcomponentts;
    }
    public void setImportcomponentts(String[][] importcomponentts) {
        this.importcomponentts = importcomponentts;
    }
    public String[][] getImportcomponentspects() {
        return importcomponentspects;
    }
    public void setImportcomponentspects(String[][] importcomponentspects) {
        this.importcomponentspects = importcomponentspects;
    }
    public String[][] getImportapproutes() {
        return importapproutes;
    }
    public void setImportapproutes(String[][] importapproutes) {
        this.importapproutes = importapproutes;
    }
    public String[] getImportstocomponent() {
        return importstocomponent;
    }
    public void setImportstocomponent(String[] importstocomponent) {
        this.importstocomponent = importstocomponent;
    }

    
}
