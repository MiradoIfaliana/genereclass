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
    String packagemodels;

    String typegettersconnection;
    String methodgettersconnection;
    String typeconnexion;
    String closeconnection;
    String typeresponse;
    String toinstance;
    String setresponse;
    String trykey;
    String catchkey;
    String exceptiontype;
    String printthrow;
    String getmsgexception;
    String finallykey;
    String diffcompare;
    String nullvalue;
    String methodcreate;
    String methodread;
    String methodreaddetailed;
    String methodreadbyid;
    String methodupdate;
    String methoddelete;
    String methodsetid;
    String statussucces;
    String statuserror;
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
    public String getPackagemodels() {
        return packagemodels;
    }
    public void setPackagemodels(String packagemodels) {
        this.packagemodels = packagemodels;
    }

    public String getTypegettersconnection() {
        return typegettersconnection;
    }
    public void setTypegettersconnection(String typegettersconnection) {
        this.typegettersconnection = typegettersconnection;
    }
    public String getMethodgettersconnection() {
        return methodgettersconnection;
    }
    public void setMethodgettersconnection(String methodgettersconnection) {
        this.methodgettersconnection = methodgettersconnection;
    }
    public String getTypeconnexion() {
        return typeconnexion;
    }
    public void setTypeconnexion(String typeconnexion) {
        this.typeconnexion = typeconnexion;
    }
    public String getCloseconnection() {
        return closeconnection;
    }
    public void setCloseconnection(String closeconnection) {
        this.closeconnection = closeconnection;
    }
    public String getTyperesponse() {
        return typeresponse;
    }
    public void setTyperesponse(String typeresponse) {
        this.typeresponse = typeresponse;
    }
    public String getToinstance() {
        return toinstance;
    }
    public void setToinstance(String toinstance) {
        this.toinstance = toinstance;
    }
    public String getSetresponse() {
        return setresponse;
    }
    public void setSetresponse(String setresponse) {
        this.setresponse = setresponse;
    }
    public String getTrykey() {
        return trykey;
    }
    public void setTrykey(String trykey) {
        this.trykey = trykey;
    }
    public String getCatchkey() {
        return catchkey;
    }
    public void setCatchkey(String catchkey) {
        this.catchkey = catchkey;
    }
    public String getExceptiontype() {
        return exceptiontype;
    }
    public void setExceptiontype(String exceptiontype) {
        this.exceptiontype = exceptiontype;
    }
    public String getPrintthrow() {
        return printthrow;
    }
    public void setPrintthrow(String printthrow) {
        this.printthrow = printthrow;
    }
    public String getGetmsgexception() {
        return getmsgexception;
    }
    public void setGetmsgexception(String getmsgexception) {
        this.getmsgexception = getmsgexception;
    }
    public String getFinallykey() {
        return finallykey;
    }
    public void setFinallykey(String finallykey) {
        this.finallykey = finallykey;
    }
    public String getDiffcompare() {
        return diffcompare;
    }
    public void setDiffcompare(String diffcompare) {
        this.diffcompare = diffcompare;
    }
    public String getNullvalue() {
        return nullvalue;
    }
    public void setNullvalue(String nullvalue) {
        this.nullvalue = nullvalue;
    }
    public String getMethodcreate() {
        return methodcreate;
    }
    public void setMethodcreate(String methodcreate) {
        this.methodcreate = methodcreate;
    }
    public String getMethodread() {
        return methodread;
    }
    public void setMethodread(String methodread) {
        this.methodread = methodread;
    }
    public String getMethodreaddetailed() {
        return methodreaddetailed;
    }
    public void setMethodreaddetailed(String methodreaddetailed) {
        this.methodreaddetailed = methodreaddetailed;
    }
    public String getMethodreadbyid() {
        return methodreadbyid;
    }
    public void setMethodreadbyid(String methodreadbyid) {
        this.methodreadbyid = methodreadbyid;
    }
    public String getMethodupdate() {
        return methodupdate;
    }
    public void setMethodupdate(String methodupdate) {
        this.methodupdate = methodupdate;
    }
    public String getMethoddelete() {
        return methoddelete;
    }
    public void setMethoddelete(String methoddelete) {
        this.methoddelete = methoddelete;
    }
    public String getMethodsetid() {
        return methodsetid;
    }
    public void setMethodsetid(String methodsetid) {
        this.methodsetid = methodsetid;
    }
    public String getStatussucces() {
        return statussucces;
    }
    public void setStatussucces(String statussucces) {
        this.statussucces = statussucces;
    }
    public String getStatuserror() {
        return statuserror;
    }
    public void setStatuserror(String statuserror) {
        this.statuserror = statuserror;
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