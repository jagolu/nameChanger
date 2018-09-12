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
    private boolean eraseAccentMarks = false;
    private boolean deleteLastSpace = false;
    private File rootDir = null;
    
    public NameChanger(){}
    
    public NameChanger(boolean changeSubDir, boolean beginWithMayus,boolean changeWithLowBar, boolean changeWithScript,
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
                !this.deleteLastSpace) return false;
        else if(!this.changeDirsName && !this.changeFileName) return false;
        else if(this.changeWithLowBar && this.changeWithScript) return false;
        else if((this.changeWithLowBar || this.changeWithScript) && 
                (this.changeWithMayus || this.changeWithoutMayus)) return false;
        else if(!this.changeDirsName && !this.changeFileName) return false;
        else if(!existsTheDir(this.rootDir)) return false;
        else return true;
    }
    
    private boolean existsTheDir(File f){
        if(f.exists()) return true;
        else return false;
    }
    
    public void changeTheNames(){
        ArrayList<File> files = this.listFilesOfADir(this.rootDir);
        for(int i=0;i<files.size();i++){
            System.out.println(files.get(i).getAbsolutePath());
        }
    }
    
    private ArrayList<File> listFilesOfADir(File dir){
        ArrayList<File> files = new ArrayList<> ();
        for (final File ficheroEntrada : dir.listFiles()) {
            if (ficheroEntrada.isDirectory()) {
                files.add(ficheroEntrada);
                files.addAll(listFilesOfADir(ficheroEntrada));
            } 
            else {
                files.add(ficheroEntrada);
            }
        }
        return files;
    }
    
    public void prueba(String prueba){
        System.out.println(this.beginWithMayus(prueba));
        System.out.println(this.changeWithLowBar(prueba));
        System.out.println(this.changeWithScript(prueba));
        System.out.println(this.changeWithMayus(prueba));
        System.out.println(this.changeWithoutMayus(prueba));
        System.out.println(this.eraseAccentMarks(prueba));
    }
    
    private String beginWithMayus(String name){
        String first = Character.toString(Character.toUpperCase(name.charAt(0)));
        return first + name.substring(1, name.length()-1);
    }
    
    private String changeWithLowBar(String name){
        return name.replace(' ', '_');
    }
    
    private String changeWithScript(String name){
        return name.replace(' ', '-');
    }
    
    private String changeWithMayus(String name){
        StringBuffer SBName = new StringBuffer();
        boolean lastSpace = false;
        for(int i=0;i<name.length();i++){
            if(!lastSpace && name.charAt(i)!=' '){
                SBName.append(name.charAt(i));
            }
            else if(!lastSpace && name.charAt(i)==' '){
                lastSpace = true;
            }
            else if(lastSpace){
                SBName.append(Character.toUpperCase(name.charAt(i)));
                lastSpace = false;
            }
        }       
       return SBName.toString();
    }
    
    private String changeWithoutMayus(String name){
        StringBuffer SBName = new StringBuffer();
        for(int i=0;i<name.length();i++){
            if(name.charAt(i)!=' ') SBName.append(name.charAt(i));
        }       
       return SBName.toString();
    }
    
    private String eraseAccentMarks(String name){
        StringBuffer SBName = new StringBuffer();
        for(int i=0;i<name.length();i++){
            switch(name.charAt(i)){
                case 'Á': SBName.append('A');
                          break;
                case 'À': SBName.append('A');
                          break;
                case 'Ä': SBName.append('A');
                          break;
                case 'Â': SBName.append('A');
                          break;
                case 'á': SBName.append('a');
                          break;
                case 'à': SBName.append('a');
                          break;
                case 'ä': SBName.append('a');
                          break;
                case 'â': SBName.append('a');
                          break;
                case 'É': SBName.append('E');
                          break;
                case 'È': SBName.append('E');
                          break;
                case 'Ë': SBName.append('E');
                          break;
                case 'Ê': SBName.append('E');
                          break;
                case 'é': SBName.append('e');
                          break;
                case 'è': SBName.append('e');
                          break;
                case 'ë': SBName.append('e');
                          break;
                case 'ê': SBName.append('e');
                          break;
                case 'Í': SBName.append('I');
                          break;
                case 'Ì': SBName.append('I');
                          break;
                case 'Ï': SBName.append('I');
                          break;
                case 'Î': SBName.append('I');
                          break;
                case 'í': SBName.append('i');
                          break;
                case 'ì': SBName.append('i');
                          break;
                case 'ï': SBName.append('i');
                          break;
                case 'î': SBName.append('i');
                          break;
                case 'Ó': SBName.append('O');
                          break;
                case 'Ò': SBName.append('O');
                          break;
                case 'Ö': SBName.append('O');
                          break;
                case 'Ô': SBName.append('O');
                          break;
                case 'ó': SBName.append('o');
                          break;
                case 'ò': SBName.append('o');
                          break;
                case 'ö': SBName.append('o');
                          break;
                case 'ô': SBName.append('o');
                          break;
                case 'Ú': SBName.append('U');
                          break;
                case 'Ù': SBName.append('U');
                          break;
                case 'Ü': SBName.append('U');
                          break;
                case 'Û': SBName.append('U');
                          break;
                case 'ú': SBName.append('u');
                          break;
                case 'ù': SBName.append('u');
                          break;
                case 'ü': SBName.append('u');
                          break;
                case 'û': SBName.append('u');
                          break;
                default : SBName.append(name.charAt(i));
            }
        }       
       return SBName.toString();
    }
}
