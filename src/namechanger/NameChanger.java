package namechanger;

import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;

public class NameChanger {
    
    private boolean changeSubDir = false;
    private boolean beginWithMayus = false;
    private boolean changeWithLowBar = false;
    private boolean changeWithScript = false;
    private boolean changeWithMayus = false;
    private boolean changeWithoutMayus = false;
    private boolean changeDirsName = false;
    private boolean changeFileName = false;
    private boolean eraseAccentMarks = false;
    private boolean deleteLastSpace = false;
    private boolean changeRootDir = false;
    private File rootDir = null;
    
    public NameChanger(){}
    
    public NameChanger(boolean changeSubDir, boolean beginWithMayus, boolean changeWithLowBar, boolean changeWithScript,
            boolean changeWithMayus, boolean changeWithoutMayus, boolean changeDirsName, boolean changeFileName, 
            boolean eraseAccentMarks, boolean deleteLastSpace, boolean changeRootDir,String rootDir){
        this.changeSubDir = changeDirsName;
        this.beginWithMayus = beginWithMayus;
        this.changeWithLowBar = changeWithLowBar;
        this.changeWithScript = changeWithScript;
        this.changeWithMayus = changeWithMayus;
        this.changeWithoutMayus = changeWithoutMayus;
        this.changeDirsName = changeDirsName;
        this.changeFileName = changeFileName;
        this.eraseAccentMarks = eraseAccentMarks;
        this.deleteLastSpace = deleteLastSpace;
        this.changeRootDir = changeRootDir;
        this.rootDir = new File(rootDir);
    }
    
    public void setChangeSubDir(boolean csd){ this.changeSubDir=csd; }
    public boolean getChangeSubDir(){ return this.changeSubDir; }
    
    public void setBeginWithMayus(boolean bwm){ this.beginWithMayus=bwm; }
    public boolean getBeginWithMayus(){ return this.beginWithMayus; }
    
    public void setChangeWithLowBar(boolean cwlb){ this.changeWithLowBar=cwlb; }
    public boolean getChangeWithLowBar(){ return  this.changeWithLowBar; }
    
    public void setChangeWithScript(boolean cws){ this.changeWithScript=cws; }
    public boolean getChangeWithScript(){ return this.changeWithScript; }
    
    public void setChangeWithMayus(boolean cwm){ this.changeWithMayus = cwm; }
    public boolean getChangeWithMayus(){ return this.changeWithMayus; }
    
    public void setChangeWithoutMayus(boolean cwm){ this.changeWithoutMayus = cwm; }
    public boolean getChangeWithoutMayus(){ return this.changeWithoutMayus; }
    
    public void setChangeDirsName(boolean cdn){ this.changeDirsName=cdn; }
    public boolean getChangeDirsName(){ return this.changeDirsName; }
    
    public void setChangeFileName(boolean cfn){ this.changeFileName=cfn; }
    public boolean getChangeFileName(){ return this.changeFileName; }
    
    public void setEraseAccentMarks(boolean eam){ this.eraseAccentMarks=eam; }
    public boolean getEraseAccentMarks(){ return this.eraseAccentMarks; }
    
    public void setDeleteLastSpace(boolean dls){ this.deleteLastSpace=dls; }
    public boolean getDeleteLastSpace(){ return this.deleteLastSpace; }
    
    public void setChangeRootDir(boolean crd){ this.changeRootDir=crd; }
    public boolean getChangeRootDir(){ return this.changeRootDir; }
    
    public void setRootDir(File rd){ this.rootDir=rd; }
    public File getRootDir(){ return this.rootDir; }
    
    
    public boolean areTheParamsRight(){
        if(!this.changeWithLowBar && !this.changeWithScript && !this.changeWithMayus && 
                !this.changeWithoutMayus && !this.beginWithMayus && !this.eraseAccentMarks &&
                !this.deleteLastSpace) return false; //Any option of change name is true
        else if(!this.changeDirsName && !this.changeFileName) return false; //It won't make any change
        else if(this.changeWithLowBar && this.changeWithScript) return false; //Cannot change by script & lowBar at the same time
        else if((this.changeWithLowBar || this.changeWithScript) && 
                (this.changeWithMayus || this.changeWithoutMayus)) return false; //Can change spaces & delete them
        else if(this.rootDir.getParent()==null) return false; //Trying to change the root dir of the OS
        else if(!this.changeRootDir && !this.changeDirsName && !this.changeSubDir) return false; //Not subdir and not change mainDir (the only file we can change)
        else return true;
    }
    
    public ArrayList<File> changeTheNames(){
        if(this.areTheParamsRight()){
            ArrayList<File> badFiles = new ArrayList<File>();
            if(this.rootDir.isDirectory()){
                if(this.changeRootDir){
                    String path = this.getRightPathOnWindows(this.rootDir.getParent());
                    String newName = this.getNewName(this.rootDir.getName());
                    if(!this.rootDir.renameTo(new File (path+newName))) badFiles.add(this.rootDir);
                }
                if(this.changeSubDir) badFiles.addAll(this.renameSubDir(rootDir.getAbsolutePath()));
            }
            else if(this.changeFileName){
                String path = this.getRightPathOnWindows(this.rootDir.getParent());
                String newName = this.getNewName(this.rootDir.getName());
                if(!this.rootDir.renameTo(new File(path+newName))) System.out.println("Salio mal");
            }
            return badFiles;
        }
        else return null;
    }
    
    private ArrayList<File> renameSubDir(String pathDir){ 
        File dir = new File (pathDir);
        ArrayList<File> badFiles = new ArrayList<> ();
        for (final File fich : dir.listFiles()) {
            if (fich.isDirectory()) {
                if(this.changeDirsName){
                    String path = this.getRightPathOnWindows(fich.getParent());
                    String newName = this.getNewName(fich.getName());
                    File newFile = new File (path+newName);
                    if(!fich.renameTo(newFile)) badFiles.add(newFile);
                }
                else if(this.changeSubDir) badFiles.addAll(renameSubDir(fich.getAbsolutePath()));
            } 
            else if(this.changeFileName){
                String path = this.getRightPathOnWindows(fich.getParent());
                String newName = this.getNewName(fich.getName());
                File newFile = new File (path+newName);
                if(!fich.renameTo(newFile)) badFiles.add(newFile);
            }
        }
        return badFiles;
    }
    
    public String getNewName(String name){
        StringBuffer SBName = new StringBuffer ();
        if(this.eraseAccentMarks) name = this.eraseAccentMarks(name);
        int i=0;
        while(i<name.length()){
            if(this.beginWithMayus && i==0) SBName.append(Character.toUpperCase(name.charAt(i)));
            else if(this.changeWithLowBar && name.charAt(i)==' ') SBName.append('_'); 
            else if(this.changeWithScript && name.charAt(i)==' ') SBName.append('-');
            else if(this.changeWithMayus && name.charAt(i)==' ' && ((i+1)<name.length() && Character.isLetter(name.charAt(i+1)))){
                SBName.append(Character.toUpperCase(name.charAt(i+1)));
                i++;
            }
            else if(this.changeWithoutMayus && name.charAt(i)==' ' && ((i+1)<name.length() && Character.isLetter(name.charAt(i+1)))){
                SBName.append(name.charAt(i+1));
                i++;
            }
            else if(this.deleteLastSpace && name.charAt(i)==' ' && ((i+1)<name.length() && !Character.isLetter(name.charAt(i+1)))){
                SBName.append(name.charAt(i+1));
                i++;
            }
            else SBName.append(name.charAt(i));
            i++;
        }       
        return SBName.toString();
    }
    
    private String eraseAccentMarks(String name){
        //String allAcents = "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝßàáâãäåæçèéêëìíîïðñòóôõöøœùúûüýÿāēīōūęįç";
        String cNormalize = Normalizer.normalize(name, Normalizer.Form.NFD);   
        String cleanString = cNormalize.replaceAll("[^\\p{ASCII}]", "");
        return cleanString;
    }
    
    public String getRightPathOnWindows(String path){
        StringBuffer sb = new StringBuffer();
        int i=0;
        while(i<path.length()){
            //The char of "/"
            if(path.charAt(i)==92) sb.append("\\");
            else sb.append(path.charAt(i));
            i++;
        }
        sb.append("\\");
        return sb.toString();
    }
}
