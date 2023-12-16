// import java.util.List;
// import java.util.ArrayList;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

// public class CodeGenerator {

//     // Fonction pour extraire les attributs existants du code
//     public static List<String> extractAttributes(String code) {
//         List<String> attributes = new ArrayList<>();
//         Pattern pattern = Pattern.compile("(\\w+\\s+\\w+\\s*;)");
//         Matcher matcher = pattern.matcher(code);
//         while (matcher.find()) {
//             attributes.add(matcher.group(1));
//         }
//         return attributes;
//     }

//     // Fonction pour générer le code mis à jour
//     public static String generateUpdatedCode(String existingCode, EntityInfo entityInfo) {
//         List<String> existingAttributes = extractAttributes(existingCode);
//         StringBuilder updatedCode = new StringBuilder(existingCode);

//         for (ColumnInfo column : entityInfo.getColumns()) {
//             String attributeDeclaration = column.getType() + " " + column.getName() + ";";
//             if (!existingAttributes.contains(attributeDeclaration)) {
//                 // Ajouter l'attribut et ses getters/setters uniquement s'il n'existe pas déjà
//                 updatedCode.append("\n").append(attributeDeclaration);
//                 updatedCode.append("\n\npublic ").append(column.getType()).append(" get")
//                         .append(column.getName().substring(0, 1).toUpperCase())
//                         .append(column.getName().substring(1)).append("() {");
//                 updatedCode.append("\n\treturn this.").append(column.getName()).append(";");
//                 updatedCode.append("\n}");
//                 updatedCode.append("\n\npublic void set").append(column.getName().substring(0, 1).toUpperCase())
//                         .append(column.getName().substring(1)).append("(").append(column.getType()).append(" ")
//                         .append(column.getName()).append(") {");
//                 // Ajouter une exception si nécessaire
//                 if (column.isException()) {
//                     updatedCode.append("\n\ttry {");
//                     updatedCode.append("\n\t\tif (").append(column.getName()).append(" < 0) {");
//                     updatedCode.append("\n\t\t\tthrow new Exception(\"inferieur a zero\");");
//                     updatedCode.append("\n\t\t}");
//                     updatedCode.append("\n\t}");
//                     updatedCode.append("\n\tcatch(Exception e) {");
//                     updatedCode.append("\n\t\t// Gérer l'exception");
//                     updatedCode.append("\n\t}");
//                 }
//                 updatedCode.append("\n\tthis.").append(column.getName()).append(" = ").append(column.getName())
//                         .append(";");
//                 updatedCode.append("\n}");
//             }
//         }

//         return updatedCode.toString();
//     }

//     public static void main(String[] args) {
//         // Exemple d'utilisation
//         String existingCode = "int idbatterie; \ndouble capacitemaxb;";
//         EntityInfo entityInfo = new EntityInfo(); // Supposons que vous avez déjà ces informations
//         entityInfo.addColumn(new ColumnInfo("idbatterie", "int", false));
//         entityInfo.addColumn(new ColumnInfo("capacitemaxb", "double", true));
//         entityInfo.addColumn(new ColumnInfo("etat", "boolean", false));
//         entityInfo.addColumn(new ColumnInfo("puissance", "float", false));

//         String updatedCode = generateUpdatedCode(existingCode, entityInfo);
//         System.out.println(updatedCode);
//     }
// }
