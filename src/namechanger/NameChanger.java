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
    private File rootDir = null;
    
    public NameChanger(){}
    
    public NameChanger(boolean changeSubDir, boolean beginWithMayus, boolean changeWithLowBar, boolean changeWithScript,
            boolean changeWithMayus, boolean changeWithoutMayus, boolean changeDirsName, boolean changeFileName, 
            boolean eraseAccentMarks, boolean deleteLastSpace, String rootDir){
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
        this.rootDir = new File(rootDir);
    }
    
    public boolean areTheParamsRight(){
        if(!this.changeWithLowBar && !this.changeWithScript && !this.changeWithMayus && 
                !this.changeWithoutMayus && !this.beginWithMayus && !this.eraseAccentMarks &&
                !this.deleteLastSpace) return false; //Any option of change name is true
        else if(!this.changeDirsName && !this.changeFileName) return false; //It won't make any change
        else if(this.changeWithLowBar && this.changeWithScript) return false; //Cannot change by script & lowBar at the same time
        else if((this.changeWithLowBar || this.changeWithScript) && 
                (this.changeWithMayus || this.changeWithoutMayus)) return false; //Can change spaces & delete them
        else if(this.rootDir.getParent()==null) return false; //Trying to change the root dir of the OS
        //else if(!this.rootDir.exists()) return false; //The dir doesn't exist
        else return true;
    }
    
    public ArrayList<File> changeTheNames(){
        if(this.areTheParamsRight()){
            ArrayList<File> badFiles = new ArrayList<File>();
            if(this.rootDir.isDirectory()){
                if(this.changeDirsName){
                    String path = this.getRightPathOnWindows(this.rootDir.getParent());
                    String newName = this.getNewName(this.rootDir.getName());
                    if(!this.rootDir.renameTo(new File (path+newName))) badFiles.add(this.rootDir);
                }
                if(this.changeSubDir){
                    badFiles.addAll(this.renameSubDir(rootDir.getAbsolutePath()));
                }
                
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
