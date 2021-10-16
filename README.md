# IM9906-VerifyingIdentityHashMap
Part of the SE Graduation Assignment

# Purpose
Formal analysis of OpenJDK's `IdentityHashMap` (http://hg.openjdk.java.net/jdk7/jdk7/jdk/file/9b8c96f96a0f/src/share/classes/java/util/IdentityHashMap.java).
This projected is related to the IM9906-IdentityHashMapSpecTester project (see: https://github.com/m4ndeb2r/IM9906-IdentityHashMapSpecTester), providing
unittests for testing the JML-specs, for example to see if the specified class invariants hold at all time.

# Setup
To replicate the setup of the project, follow the steps below:
1. create a KeY project in Eclipse (use Eclipse 2020-03, with KeY plugin 2.6.3),
1. prepare the class for verification with KeY,
1. generate stubs for the classes depended on,
1. strip generics from the class under verification,
1. solve any problems after removal of generics,
1. load the class under verification in KeY.

## Create a KeY project in Eclipse
Prerequisites: Eclipse + KeY plugin for Eclipse. The Eclipse version we used is 2020-03. The KeY pluging version is 2.6.3. The Java version used is Java SE 7 \[1.7.0_80\] because KeY is not accepting a higher (>7) version.
Create a new KeY-project. In the menu, choose:
* File > New > Project,
* choose: KeY > KeY Project,
* click next button,
* choose the defaults, except name (IM9906 - VerifyingIdentityHashMap) and JRE (Java SE 7 \[1.7.0_80\]).

## Prepare the class under verification
In your new (empty) KeY project, follow these steps:
* create a package `java.util` in your src directory,
* in this package, create a new (empty) class named `VerifiedIdentityHashMap`,
* copy the sourcecode from [http://hg.openjdk.java.net/jdk7/jdk7/jdk/file/9b8c96f96a0f/src/share/classes/java/util/IdentityHashMap.java] and paste it into your newly created class,
* replace all occurences of the string `IdentityHashMap` in the file with `VerifiedIdentityHashMap` to match the filename of the class,
* save the class.

Note: the class under verification is called `VerifiedIdentityHashMap` instead of its original name `IdentityHashMap` to prevent it from clashing with the name of the original class in the JDK library in the same package.

## Generate stubs for the classes depended on
The class under verification is dependent of a number of library classes. For the purpose of formal analysis, we don't need binaries of these classes, but we do need to generate stubs for them. The KeY plugin is able to do this for us:
* select your project, and right-click on it for the context menu,
* from the context menu, choose Generate Stubs,
* you will be prompted for a directory name (choose "jre") and a location (select radio button "Boor Class Path"),
* click the finish button.

Three packages containing stub classes will be generated: `java.io`, `java.lang`, and `java.util`.

## Remove generics from VerifiedIdentityHashMap
* select your project, and right-click on it for the context menu,
* from the context menu, choose Remove Generics (this will fail the first time, with errors on two lines),
* fix the errors on line 1148 and 1160 (they are similar) by changing `AbstractMap.SimpleEntry<>` to `AbstractMap.SimpleEntry<Object, Object>`, and retry removing the generics. This time you should succeed.

## Fix some problems after removing generics
Some trivial problems occur after removing the generics. These have to be fixed mannually:
* on line 504 and 505 a class cast is now required; change these lines from:
  ```
  for (Entry e: m.entrySet())
	  put(e.getKey(), e.getValue());
  ```
  to:
  ```
  for (Object o: m.entrySet()) {
	  Entry e = (Entry) o;
	  put(e.getKey(), e.getValue());
  }
  ```
* save the class

Now, the class can be loaded in KeY. 

Note: The KeY plugin Eclipse complains about the `remove` method on line 979 (Cycle detected). However, this does not seem to be a real problem. Threrefore, it is ignored. 

## Start the stand-alone KeY tool
A version 2.9 of the stand-alone KeY tool is provided in the directory key2.9 this repository. You can start the tool as follows:
* `$ java -Xmx8G -jar ./key-exe-weigl_ihmapCaseStudy-202110131052.jar` 

## Load VerifiedIdentityHashMap in KeY
* Open the `IdentityHashMap.key` file that is available in the root of the project.
