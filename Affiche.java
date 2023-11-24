package main;
import java.sql.Connection;

import javax.swing.text.View;

import connect.*;
public class Affiche {

    public static void main(String[] args)throws Exception{
        String []types={"Table","view"};
        Service service=new Service("cs", "./classes", "object",types,"test",null);//ireo ihan no tena miasa aloha
        Connection connection=new Connect().getConnectionPsql();
        //connection=new Connect().getConnectionMysql();
        service.createclassOfdatabase(connection);
        

        //System.out.println(input.substring(debutIndex+debut.length(), finIndex));
        
    }
}
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

