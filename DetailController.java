package connect;

import java.lang.reflect.Field;

public class DetailController
{
    String packagekey;
    String importkey;
    String annotationController;
    String annotationRoute;
    String scopeController;
    String annotationGet;
    String annotationPost;
    String annotationPut;
    String annotationDelete;
    String throwskey;
    String newthrow;
    String bracketopen;
    String bracketclose;
    String endline;
    String extension;
    String extendskey;
    String classextends;
    String pathAttribute;
    String requestAttribute;
    String bodyAttribute;
    String returnType;
    String returnkey;
    String identifierType;
    String[] libraries;
    String caracteres;
    public String getPackagekey() {
        return packagekey;
    }
    public void setPackagekey(String packagekey) {
        this.packagekey = packagekey;
    }
    public String getImportkey() {
        return importkey;
    }
    public void setImportkey(String importkey) {
        this.importkey = importkey;
    }
    public String getAnnotationController() {
        return annotationController;
    }
    public void setAnnotationController(String annotationController) {
        this.annotationController = annotationController;
    }
    public String getAnnotationRoute() {
        return annotationRoute;
    }
    public void setAnnotationRoute(String annotationRoute) {
        this.annotationRoute = annotationRoute;
    }
    public String getScopeController() {
        return scopeController;
    }
    public void setScopeController(String scopeController) {
        this.scopeController = scopeController;
    }
    public String getAnnotationGet() {
        return annotationGet;
    }
    public void setAnnotationGet(String annotationGet) {
        this.annotationGet = annotationGet;
    }
    public String getAnnotationPost() {
        return annotationPost;
    }
    public void setAnnotationPost(String annotationPost) {
        this.annotationPost = annotationPost;
    }
    public String getAnnotationPut() {
        return annotationPut;
    }
    public void setAnnotationPut(String annotationPut) {
        this.annotationPut = annotationPut;
    }
    public String getAnnotationDelete() {
        return annotationDelete;
    }
    public void setAnnotationDelete(String annotationDelete) {
        this.annotationDelete = annotationDelete;
    }
    public String getThrowskey() {
        return throwskey;
    }
    public void setThrowskey(String throwskey) {
        this.throwskey = throwskey;
    }
    public String getNewthrow() {
        return newthrow;
    }
    public void setNewthrow(String newthrow) {
        this.newthrow = newthrow;
    }
    public String getBracketopen() {
        return bracketopen;
    }
    public void setBracketopen(String bracketopen) {
        this.bracketopen = bracketopen;
    }
    public String getBracketclose() {
        return bracketclose;
    }
    public void setBracketclose(String bracketclose) {
        this.bracketclose = bracketclose;
    }
    public String getEndline() {
        return endline;
    }
    public void setEndline(String endline) {
        this.endline = endline;
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    } 
    public String getExtendskey() {
        return extendskey;
    }
    public void setExtendskey(String extendskey) {
        this.extendskey = extendskey;
    }
    public String getClassextends() {
        return classextends;
    }
    public void setClassextends(String classextends) {
        this.classextends = classextends;
    }
    public String getPathAttribute() {
        return pathAttribute;
    }
    public void setPathAttribute(String pathAttribute) {
        this.pathAttribute = pathAttribute;
    }
    public String getRequestAttribute() {
        return requestAttribute;
    }
    public void setRequestAttribute(String requestAttribute) {
        this.requestAttribute = requestAttribute;
    }
    public String getBodyAttribute() {
        return bodyAttribute;
    }
    public void setBodyAttribute(String bodyAttribute) {
        this.bodyAttribute = bodyAttribute;
    }
    public String getReturnType() {
        return returnType;
    }
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
    public String getReturnkey() {
        return returnkey;
    }
    public void setReturnkey(String returnkey) {
        this.returnkey = returnkey;
    }
    public String getIdentifierType() {
        return identifierType;
    }
    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }
    public String[] getLibraries() {
        return libraries;
    }
    public void setLibraries(String[] libraries) {
        this.libraries = libraries;
    }  
    public String getCaracteres() {
        return caracteres;
    }
    public void setCaracteres(String caracteres) {
        this.caracteres = caracteres;
    }
    public void affiche()throws Exception{
        Field[] fields=this.getClass().getDeclaredFields();
        Object obj=null;
        String[] strs=null;
        for(int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            obj=fields[i].get(this);
            if(fields[i].getType().isArray()==true){
               strs=(String[])obj;
               System.out.print("\n"+fields[i].getName()+" :"+strs+":");
               if(strs!=null){
                    for(int j=0;j<strs.length;j++){
                        System.out.print(strs[j]+",");
                    }
               }
               System.out.println("\n");
            }else{
                System.out.println(fields[i].getName()+" :"+obj);
                fields[i].setAccessible(false);
            }
        }
    }
    
}