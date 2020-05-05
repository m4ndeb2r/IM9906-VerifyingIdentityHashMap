# IM9906-VerifyingIdentityHashMap
SE Graduation Assignment

# Purpose
Formal analysis of OpenJDK's `IdentityHashMap` ([http://hg.openjdk.java.net/jdk7/jdk7/jdk/file/9b8c96f96a0f/src/share/classes/java/util/IdentityHashMap.java]).

# Setup
To replicate the setup of the project, follow the steps below:
1. create a KeY project in Eclipse (use Eclipse 2020-03, with KeY plugin 2.6.3)
1. prepare the class for verification with KeY
1. generate stubs for the classes depended on
1. strip generics from the class under verification
1. solve any problems after removal of generics
1. load the class under verification in KeY

## Create a KeY project in Eclipse
Prerequisites: Eclipse + KeY plugin for Eclipse. The Eclipse version we used is 2020-03. The KeY pluging version is 2.6.3. The Java version used is Java SE 7 \[1.7.0_80\] because KeY is not accepting a higher (>7) version.
Create a new KeY-project. In the menu, choose:
* File > New > Project
* choose: KeY > KeY Project
* click next button
* choose the defaults, except name (IM9906 - VerifyingIdentityHashMap) and JRE (Java SE 7 \[1.7.0_80\])

## Prepare the class under verification
In your new (empty) KeY project, follow these steps:
* create a package `java.util` in your src directory
* in this package, create a new (empty) class named `VerifiedIdentityHashMap`
* copy the sourcecode from [http://hg.openjdk.java.net/jdk7/jdk7/jdk/file/9b8c96f96a0f/src/share/classes/java/util/IdentityHashMap.java] and paste it into your newly created class
* replace all occurences of the string `IdentityHashMap` in the file with `VerifiedIdentityHashMap` to match the filename of the class
* save the class

## Generate stubs for the classes depended on
The class under verification is dependent of a number of library classes. For the purpose of formal analysis, we don't need binaries of these classes, but we do need to generate stubs for them. The KeY plugin is able to do this for us:
* select your project, and right-click on it for the context menu
* from the context menu, choose Generate Stubs
* you will be prompted for a directory name (choose "jre") and a location (select radio button "Boor Class Path")
* click the finish buttom

Three packages containing stub classes will be generated: `java.io`, `java.lang`, and `java.util`.

## Remove generics from VerifiedIdentityHashMap

