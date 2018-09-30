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
  - "<strong>Begin with capital letters</strong>": If this is activated, will change the first letter of the directory/file to a capital letter. 
  Example: <I>filename.txt -> Filename.txt</I>
  - "<strong>Erase accent marks</strong>": If this is activated, will change all the letters with accent marks and "rare" letters to the letter without the accent. 
  Example: <I>ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝßàáâãäåæçèéêëìíîïðñòóôõöøœùúûüýÿāēīōūęįç.txt -> AAAAAACEEEEIIIINOOOOOUUUUYaaaaaaceeeeiiiinooooouuuuyyaeioueic.txt</I>
  - "<strong>Change dirs name</strong>": If this is activated, will change the name of all the files that it will find.
  - "<strong>Delete last spaces</strong>": If this is activated, will delete the last spaces of the files. 
  Example: <I>Example (2) .txt -> Example(2).txt</I>
  - "<strong>Change the root dir name</strong>": If this is activated and you have chosen a directory, will change the name of the dir you have chosen.
  
  
  
Now, the big thing of NameChanger with what thing you can replace the spaces. There are 5 options, you only can choose one of them:
   - "<strong>Not to change spaces</strong>": This is the preselected option, this won't do nothing with the spaces.
  Example: <I>new filename.txt -> new filename.txt</I>
  If the options <strong>Delete last spaces</strong> is activated with that one the result will be this: <I>new filename .txt -> new filename.txt</I>
  - "<strong>Change spaces with low bar</strong>": If this options is selected, the spaces will be replaced with a low bar. (This option can be chosen with the option <strong>Delete last spaces</strong>
  Example: <I>new filename.txt -> new_filename.txt</I>
  - "<strong>Change spaces with script</strong>": If this options is selected, the spaces will be replaced with a script. (This option can be chosen with the option <strong>Delete last spaces</strong>
  Example: <I>new filename.txt -> new-filename.txt</I>
  - "<strong>Delete space</strong>": If this options is selected, the spaces will be deleted. (This option can be chosen with the option <strong>Delete last spaces</strong>
  Example: <I>new filename.txt -> newfilename.txt</I>
  - "<strong>Delete space (Next letter on capital)</strong>": If this options is selected, the spaces will be deleted and the letter of the next word will be on capital. (This option can be chosen with the option <strong>Delete last spaces</strong>
  Example: <I>new filename.txt -> newFilename.txt</I>
  
  
  
  
## Requirements

NameChanger.exe requires the following:
- Java 1.7.

The project needs the jar 
- <a href="https://commons.apache.org/proper/commons-io/download_io.cgi">Apache Commons IO jar</a> in its 2.6 version.





## Installation

NameChanger doesn't need any installation, it's an exe file!






## Download

### Version 1.0

##### Jar
<a href="https://mega.nz/#!NBcQUIJJ!a17ZpxuqLdmI3XgECxI_iwxyUZGTXJ79BB_51ypUDD8">nameChanger.jar</a>
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
        boolean changeSubDir = true;  //For the option "Change the sub dirs"
        boolean beginWithMayus = true; //For the options "Begin with capital letters"
        boolean changeWithLowBar = true; //For the option "Change spaces with low bar"
        boolean changeWithScript = false; //For the option "Change spaces with script"
        boolean changeWithMayus = false; //For the option "Delete space (Next letter on capital)"
        boolean changeWithoutMayus = false; //For the option "Delete space"
        boolean changeDirsName = true; //For the option "Change dirs name"
        boolean changeFileName = true; //For the option "Change files name"
        boolean eraseAccentMarks = true; //For the option "Erase accent marks"
        boolean deleteLastSpace = true; //For the option "Delete last spaces"
        boolean changeRootDir = true; //For the option "Change the root dir name"
        String rootDir = "path_to_my_file_or_directory"; //The absolute path to the file or directory
        
        ArrayList<String> badFiles = new ArrayList<String>();
        
        
        NameChanger nc = new NameChanger(changeSubDir, beginWithMayus, changeWithLowBar, changeWithScript,
            changeWithMayus, changeWithoutMayus, changeDirsName, changeFileName, eraseAccentMarks, deleteLastSpace, 
            changeRootDir, rootDir));
            
        
       badFiles =  nc.changeTheNames(); 
/*-----------------------------------------------------------GETTERS---SETTERS--------------------------------------------------------*/
       nc.setChangeSubDir(true); //For the option "Change the sub dirs"
       nc.setBeginWithMayus(true); //For the options "Begin with capital letters"
       nc.setChangeWithLowBar(true); //For the option "Change spaces with low bar"
       nc.setChangeWithScript(false); //For the option "Change spaces with script"
       nc.setChangeWithMayus(false); //For the option "Delete space (Next letter on capital)"
       nc.setChangeWithoutMayus(false);  //For the option "Delete space"
       nc.setChangeDirsName(true); //For the option "Change dirs name"
       nc.setChangeFileName(true); //For the option "Change files name"
       nc.setEraseAccentMarks(true); //For the option "Erase accent marks"
       nc.setDeleteLastSpace(true); //For the option "Delete last spaces"
       nc.setChangeRootDir(true); //For the option "Change the root dir name"
       nc.setRootDir(new File("absolute_path_to_your_directory_or_file"); //The absolute path to the file or directory
       //or nc.setRootDir("absolute_path_to_your_directory_or_file");
       
       //You can also use the getters of that options.
    }
}
```
The function changeTheNames() will change the names and will return an ArrayList with the absolute path of the file that NameChanger couldn't change.

There is some "laws" on the booleans options (if them are not like below, the NameChanger won't change anything): 
  - One of these options must be true (changeWithLowBar, changeWithScript, changeWithMayus, changeWithoutMayus, beginWithMayus, eraseAccentMarks, deleteLastSpace).
  - One of these options must be true (changeDirsname, changeFileName).
  - Just one (or none) of these options must be true (changeWithLowBar, changeWithScript, changeWithMayus, changeWithoutMayus). If all of them are false will be like choose the option <strong>Not to change spaces</strong>.
  - The file or directory must exist.
  - The directory or file must have a parent.
  - One of these options must be true (changeRootDir, changeDirsName, changeSubDir).
