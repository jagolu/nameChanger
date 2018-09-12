package namechanger;

import java.io.File;
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
    private File rootDir = null;
    
    public NameChanger(){}
    
    public NameChanger(boolean changeSubDir, boolean beginWithMayus,boolean changeWithLowBar, boolean changeWithScript,
            boolean changeWithMayus, boolean changeWithoutMayus, boolean changeDirsName, boolean changeFileName, String rootDir){
        this.changeSubDir = changeDirsName;
        this.beginWithMayus = beginWithMayus;
        this.changeWithLowBar = changeWithLowBar;
        this.changeWithScript = changeWithScript;
        this.changeWithMayus = changeWithMayus;
        this.changeWithoutMayus = changeWithoutMayus;
        this.changeDirsName = changeDirsName;
        this.changeFileName = changeFileName;
        this.rootDir = new File(rootDir);
    }
    
    public boolean areTheParamsRight(){
        if(!this.changeWithLowBar && !this.changeWithScript && !this.changeWithMayus && !this.changeWithoutMayus && !this.beginWithMayus) return false;
        else if(!this.changeDirsName && !this.changeFileName) return false;
        else if(this.changeWithLowBar && this.changeWithScript) return false;
        else if((this.changeWithLowBar || this.changeWithScript) && (this.changeWithMayus || this.changeWithoutMayus)) return false;
        else if(!this.changeDirsName && !this.changeFileName) return false;
        else if(!existsTheDir(this.rootDir)) return false;
        else return true;
    }
    
    private boolean existsTheDir(File f){
        if(f.exists()) return true;
        else return false;
    }
    
    private ArrayList<File> listFilesOfADir(File dir){
        ArrayList<File> files = new ArrayList<File> ();
        for (final File ficheroEntrada : dir.listFiles()) {
            if (ficheroEntrada.isDirectory()) {
                files.add(ficheroEntrada);
                listFilesOfADir(ficheroEntrada);
            } 
            else {
                files.add(ficheroEntrada);
            }
        }
        return files;
    }
}
