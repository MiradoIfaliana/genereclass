package connect;
public class DetailTable
{ 
  String nametable;
  String columnname;
  String columntype;
  String columntechtype;
  String libimport;

  boolean estPK;
  boolean estFK;
  String tabOriginFk;
  String colFromOrigin;


    
    public DetailTable() {
    }
    public DetailTable(String nametable, String columnname, String columntype, String columntechtype, String libimport,boolean estPK,boolean estFK,String tabOriginFk,String colFromOrigin) {
        this.nametable = nametable;
        this.columnname = columnname;
        this.columntype = columntype;
        this.columntechtype = columntechtype;
        this.libimport = libimport;
        this.estPK=estPK;
        this.estFK=estFK;
        this.tabOriginFk=tabOriginFk;
        this.colFromOrigin=colFromOrigin;
    }
    public String getNametable() {
        return nametable;
    }
    public void setNametable(String nametable) {
        this.nametable = nametable;
    }
    public String getColumnname() {
        return columnname;
    }
    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }
    public String getColumntype() {
        return columntype;
    }
    public void setColumntype(String columntype) {
        this.columntype = columntype;
    }
    public String getColumntechtype() {
        return columntechtype;
    }
    public void setColumntechtype(String columntechtype) {
        this.columntechtype = columntechtype;
    }
    public String getLibimport() {
        return libimport;
    }
    public void setLibimport(String libimport) {
        this.libimport = libimport;
    }
    public boolean isEstPK() {
        return estPK;
    }
    public void setEstPK(boolean estPK) {
        this.estPK = estPK;
    }
    public boolean isEstFK() {
        return estFK;
    }
    public void setEstFK(boolean estFK) {
        this.estFK = estFK;
    }
    public String getTabOriginFk() {
        return tabOriginFk;
    }
    public void setTabOriginFk(String tabOriginFk) {
        this.tabOriginFk = tabOriginFk;
    }
    public String getColFromOrigin() {
        return colFromOrigin;
    }
    public void setColFromOrigin(String colFromOrigin) {
        this.colFromOrigin = colFromOrigin;
    }

    
    
}