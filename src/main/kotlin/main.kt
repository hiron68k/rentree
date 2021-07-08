import java.io.BufferedReader
import java.io.File
import java.io.FilenameFilter
import java.util.*

fun main(args: Array<String>) {
    //引数で渡されたディレクトリのファイルリストを取得する
    val dirList = fileList(args[0])
    println("余計なファイルがないこと、順序が正しいことを確認してください")
    print("よろしいですか?(yes/ ) ")
    if(readLine().equals("yes") ) {
        // テキストファイルを読み込む
        readTextFile(File("./README.md")).forEach{println(">  $it")}
    } else {
        //何もしないで終了する
        return
    }
}

/// fileList
/// 引数で渡されたディレクトリのファイル一覧を返す
/// ただし、tree.txtは除外する
fun fileList(dirName: String) : Array<String> {

    val filter = FilenameFilter { _, str -> //指定文字列でフィルタする
        //`tree.txt`は除外する`
        str.indexOf("tree.txt") == -1
    }

    // ファイル一覧を取得するディレクトリ
    val dir = File(dirName)

    //Fileクラスのlistメソッドを使用してファイル一覧を取得する
    val fileList = dir.list(filter) ?: return arrayOf("")
    Arrays.sort(fileList)

    // 取得したファイル一覧を表示する
    fileList.forEach { fileName ->
        println(fileName)
    }

    return fileList
}

fun readTextFile(file: File) : MutableList<String>{

    val inputStream = file.inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    return lineList
}