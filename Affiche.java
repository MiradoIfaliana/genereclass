package main;
import java.sql.Connection;
import connect.*;
public class Affiche {

    public static void main(String[] args)throws Exception{
        String []types={"Table","view"};
        Service service=new Service("cs", "./classes", "object",types,"test",null);//ireo ihan no tena miasa aloha
        Connection connection=new Connect().getConnectionPsql();
        //connection=new Connect().getConnectionMysql();
        service.createclassOfdatabase(connection);

    }
}

