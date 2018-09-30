# NameChanger


NameChanger, as its name suggests, changes the name of the directories and files. The current version of NameChanger is only for Windows OS and supports all languages with latin characters.


Read more about NameChanger: 
  - [Features](#features)
  - [Requirements](#requirements)
  - [Installation](#installation)
  - [Download](#download)
  - [Getting started](#getting-started)





## Features

With NameChanger, you can change the name of files and directories (and the file and directories inside of them). Below are the options that you can choose with NameChanger program. All these options are preselected but you can deselect them:

  - "<strong>Change the subs dirs</strong>": If this is activated, will navigate inside the directories and will change the name of the things you have inside of them.
  - "<strong>Change files name</strong>": If this is activated, will change the name of all the files that it will find.
  - "<strong>Begin with capital letters</strong>": If this is activated, will change the first letter of the directory/file to a capital letter. Example: 
    <p><I>filename.txt -> Filename.txt</I></p>
  - "<strong>Erase accent marks</strong>": If this is activated, will change all the letters with accent marks and "rare" letters to the letter without the accent. Example: 
    <p><I>ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝßàáâãäåæçèéêëìíîïðñòóôõöøœùúûüýÿāēīōūęįç.txt -> AAAAAACEEEEIIIINOOOOOUUUUYaaaaaaceeeeiiiinooooouuuuyyaeioueic.txt</I></p>
  - "<strong>Change dirs name</strong>": If this is activated, will change the name of all the files that it will find.
  - "<strong>Delete last spaces</strong>": If this is activated, will delete the last spaces of the files. Example: 
    <p><I>Example (2) .txt -> Example(2).txt</I></p>
  - "<strong>Change the root dir name</strong>": If this is activated and you have chosen a directory, will change the name of the dir you have chosen.
</br>
</br>
Now, the big thing of NameChanger with what thing you can replace the spaces. There are 5 options, you only can choose one of them:

  - "<strong>Not to change spaces</strong>": This is the preselected option, this won't do nothing with the spaces. Example: 
    <p><I>new filename.txt -> new filename.txt</I></p>
    <p>If the option <strong>Delete last spaces</strong> is activated with that one the result will be this: <I>new filename .txt -> new filename.txt</I>
  
  - "<strong>Change spaces with low bar</strong>": If this option is selected, the spaces will be replaced with a low bar. (This option can be chosen with the option <strong>Delete last spaces</strong>). Example: 
    <p><I>new filename.txt -> new_filename.txt</I></p>
  
  - "<strong>Change spaces with script</strong>": If this option is selected, the spaces will be replaced with a script. (This option can be chosen with the option <strong>Delete last spaces</strong>). Example: 
    <p><I>new filename.txt -> new-filename.txt</I></p>
  
  - "<strong>Delete space</strong>": If this option is selected, the spaces will be deleted. (This option can be chosen with the option <strong>Delete last spaces</strong>). Example: 
    <p><I>new filename.txt -> newfilename.txt</I></p>
  
  - "<strong>Delete space (Next letter on capital)</strong>": If this option is selected, the spaces will be deleted and the letter of the next word will be on capital. (This option can be chosen with the option <strong>Delete last spaces</strong>). Example: 
    <p><I>new filename.txt -> newFilename.txt</I></p>
  
  
  
  
## Requirements

NameChanger.exe requires the following:
- Java 1.7.

The project needs the jar 
- <a href="https://commons.apache.org/proper/commons-io/download_io.cgi">Apache Commons IO jar</a> in its 2.6 version.





## Installation

NameChanger doesn't need any installation, it's just an exe file!






## Download

### Version 1.0

##### Jar
<a href="https://mega.nz/#!Fc0nlbZC!K9gct8x9Gh5o4E479fWvjOPYa8Ux70Hie4sC3XC4DLY">nameChanger.jar</a>
##### Windows
<a href="https://mega.nz/#!0RV2nAwL!jxsl5DGKWmFNf8oSLOQFnjNj1UIdoSAUsnJ5XzxvxEc">NameChanger.exe</a>
##### Linux
Developing ...







## Getting started

The following is a basic usage example of the NameChanger library:

```java
package javaapplication1;

import namechanger.NameChanger;
import java.util.ArrayList;
import java.io.File;

public class JavaApplication1 {

    public static void main(String[] args) {
        //For the option "Change the sub dirs"
        boolean changeSubDir = true;  
        
        //For the option "Begin with capital letters"
        boolean beginWithMayus = true; 
        
        //For the option "Change spaces with low bar"
        boolean changeWithLowBar = true; 
        
        //For the option "Change spaces with script"
        boolean changeWithScript = false; 
        
        //For the option "Delete space (Next letter on capital)"
        boolean changeWithMayus = false; 
        
        //For the option "Delete space"
        boolean changeWithoutMayus = false; 
        
        //For the option "Change dirs name"
        boolean changeDirsName = true; 
        
        //For the option "Change files name"
        boolean changeFileName = true; 
        
        //For the option "Erase accent marks"
        boolean eraseAccentMarks = true; 
        
        //For the option "Delete last spaces"
        boolean deleteLastSpace = true; 
        
        //For the option "Change the root dir name"
        boolean changeRootDir = true; 
        
        //The absolute path to the file or directory
        String rootDir = "path_to_my_file_or_directory"; 
        
        ArrayList<String> badFiles = new ArrayList<String>();
        
        
        NameChanger nc = new NameChanger(changeSubDir, beginWithMayus, changeWithLowBar, 
            changeWithScript, changeWithMayus, changeWithoutMayus, changeDirsName, 
            changeFileName, eraseAccentMarks, deleteLastSpace, changeRootDir, rootDir));
            
        
       badFiles =  nc.changeTheNames(); 
/*---------------------------------GETTERS---SETTERS-----------------------------------------*/
       //For the option "Change the sub dirs"
       nc.setChangeSubDir(true); 
       
       //For the option "Begin with capital letters"
       nc.setBeginWithMayus(true); 
       
       //For the option "Change spaces with low bar"
       nc.setChangeWithLowBar(true); 
       
       //For the option "Change spaces with script"
       nc.setChangeWithScript(false); 
       
       //For the option "Delete space (Next letter on capital)"
       nc.setChangeWithMayus(false); 
       
       //For the option "Delete space"
       nc.setChangeWithoutMayus(false); 
       
       //For the option "Change dirs name"
       nc.setChangeDirsName(true); 
       
       //For the option "Change files name"
       nc.setChangeFileName(true); 
       
       //For the option "Erase accent marks"
       nc.setEraseAccentMarks(true); 
       
       //For the option "Delete last spaces"
       nc.setDeleteLastSpace(true); 
       
       //For the option "Change the root dir name"
       nc.setChangeRootDir(true); 
       
       //The absolute path to the file or directory
       nc.setRootDir(new File("absolute_path_to_your_directory_or_file"); 
       
       //The absolute path to the file or directory
       nc.setRootDir("absolute_path_to_your_directory_or_file"); 
       
       
       
       //The option "Change the sub dirs"
       boolean changeSubDir = nc.getChangeSubDir(); 
       
       //The option "Begin with capital letters"
       boolean beginWithMayus = nc.getBeginWithMayus(); 
       
       //The option "Change spaces with low bar"
       boolean changeWithLowBar = nc.getChangeWithLowBar(); 
       
       //The option "Change spaces with script"
       boolean changeWithScript = nc.getChangeWithScript(); 
       
       //The option "Delete space (Next letter on capital)"
       boolean changeWithMayus = nc.getChangeWithMayus(); 
       
       //The option "Delete space"
       boolean changeWithoutMayus = nc.getChangeWithoutMayus(); 
       
       //The option "Change dirs name"
       boolean changeDirsName = nc.getChangeDirsName();
       
       //The option "Change files name"
       boolean changeDirsName = nc.getChangeFileName(); 
       
       //The option "Erase accent marks"
       boolean changeFileName = nc.getEraseAccentMarks(); 
       
       //The option "Delete last spaces"
       boolean deleteLastSpace = nc.getDeleteLastSpace(); 
       
       //The option "Change the root dir name"
       boolean changeRootDir = nc.getChangeRootDir(); 
       
       //The absolute path to the file or directory
       java.io.File rootDir = nc.getRootDir(); 
       
       //The absolute path to the file or directory
       String absolutePath = nc.getPathRootDir(); 
    }
}
```
The function changeTheNames() will change the names and will return:
  - An ArrayList with the absolute path of the files that NameChanger couldn't change. 
  - Null if the boolean options weren't right.
  - An empty ArrayList if it wasn't any problem.

There is some "laws" on the booleans options (if them are not like below, the NameChanger won't change anything): 
  - One of these options must be true (changeWithLowBar, changeWithScript, changeWithMayus, changeWithoutMayus, beginWithMayus, eraseAccentMarks, deleteLastSpace).
  - One of these options must be true (changeDirsname, changeFileName).
  - Just one (or none) of these options must be true (changeWithLowBar, changeWithScript, changeWithMayus, changeWithoutMayus). If all of them are false will be like choose the option <strong>Not to change spaces</strong>.
  - The file or directory must exist.
  - The directory or file must have a parent.
  - One of these options must be true (changeRootDir, changeDirsName, changeSubDir).
