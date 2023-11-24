package connect;
public class DetailTable
{ 
  String nametable;
  String columnname;
  String columntype;
  String columntechtype;
  String libimport;
    
    public DetailTable() {
    }
    public DetailTable(String nametable, String columnname, String columntype, String columntechtype, String libimport) {
        this.nametable = nametable;
        this.columnname = columnname;
        this.columntype = columntype;
        this.columntechtype = columntechtype;
        this.libimport = libimport;
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
    
}