# rentree

Rename all files in the target directory with the contents of `./tree.txt`.

## Usage
1. Move current directory to target directory.
2. create `tree.txt` file (ex. maketree.bat)
3. rentree

## Encode
`tree` command output UTF-16 Text.  
But `maketree.bat` output Shift-JIS.  
The condition is that 'tree.txt' is encoded in Shift-JIS.

## Development Environment

### Command for create `.gitignore`
```
curl -sS https://raw.githubusercontent.com/github/gitignore/master/{\
Java.gitignore,\
Gradle.gitignore,\
Global\/JetBrains.gitignore,\
Global\/Eclipse.gitignore,\
Global\/NetBeans.gitignore,\
Global\/macOS.gitignore,\
Global\/Linux.gitignore,\
Global\/Windows.gitignore\
} >> .gitignore
```

