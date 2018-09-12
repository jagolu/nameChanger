package namechanger;

public class NameChanger {
    
    private boolean changeSubDir = false;
    private boolean changeWithLowBar = false;
    private boolean changeWithScript = false;
    private boolean changeWithMayus = false;
    private boolean changeWithoutMayus = false;
    private boolean changeDirsName = false;
    private boolean changeFileName = false;
    
    public NameChanger(){}
    
    public NameChanger(boolean changeSubDir, boolean changeWithLowBar, boolean changeWithScript,
            boolean changeWithMayus, boolean changeWithoutMayus, boolean changeDirsName, boolean changeFileName){
        this.changeSubDir = changeDirsName;
        this.changeWithLowBar = changeWithLowBar;
        this.changeWithMayus = changeWithMayus;
        this.changeWithMayus = changeWithMayus;
        this.changeWithoutMayus = changeWithoutMayus;
        this.changeDirsName = changeDirsName;
        this.changeFileName = changeFileName;
    }
    
}
