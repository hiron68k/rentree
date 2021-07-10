# rentree

Rename all files in the target directory with the contents of `./tree.txt`.

## Usage
1. Move current directory to target directory.
2. create `tree.txt` file (ex. tree -f | sort > tree.txt)
3. rentree

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

