namespace entite;

public class Stylematiere_v{
    int idstyle; 
    string nomstyle; 
    int idmatiere; 
    string nommatiere; 

    public Stylematiere_v(){ }
    public int Idstyle{ get => this.idstyle ; set => this.idstyle = value; }
    public string Nomstyle{ get => this.nomstyle ; set => this.nomstyle = value; }
    public int Idmatiere{ get => this.idmatiere ; set => this.idmatiere = value; }
    public string Nommatiere{ get => this.nommatiere ; set => this.nommatiere = value; }

}
