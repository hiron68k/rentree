import java.io.*
import java.util.*

fun main() {
    //引数で渡されたディレクトリのファイルリストを取得する
    val dirList = fileList(".")
    println("余計なファイルがないこと、順序が正しいことを確認してください")
    print("よろしいですか?(yes/ ) ")
    if(readLine().equals("yes") ) {
        // 変更前ファイル名を保存
        backupOldNames(dirList)
        //テキストファイルを読み込む
        val newNames = readTextFile(File("tree.txt"))
        // 変名
        renameFiles(dirList, newNames)
    } else {
        //何もしないで終了する
        return
    }
}

/* fileList
 引数で渡されたディレクトリのファイル一覧を返す
 ただし、tree.txtは除外する
 */
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

/* readTextFile
    テキストファイルを改行区切りで文字列コレクション型で返す
    行の先頭が"/"の行を最後に、それ以降はコレクションに加えない
 */
fun readTextFile(file: File) : MutableList<String> {

    val inputStream = file.inputStream()
    val lineList = mutableListOf<String>()
    var doAdd = true

    inputStream.bufferedReader().forEachLine {
        if(it.isNotEmpty() && doAdd) {
            lineList.add(it)
            if(it[0] == '/') {
                doAdd = false
            }
        }
    }
    return lineList
}

/*  backupOldNames
    変更前のファイル名のリストをテキストファイルに保存する
 */
fun backupOldNames(dirList: Array<String>) {
    val fw = FileWriter("oldtree.txt")  // filtering by fileList()
    val pw = PrintWriter(BufferedWriter(fw))

    dirList.forEach {
        pw.println(it)
    }
    pw.close()
}

/*  renameFiles
    ターゲットディレクトリの全ファイルを変更
 */
fun renameFiles(dirList: Array<String>, newNames: MutableList<String>) {

    var i = 0
    dirList.forEach {
        //ファイル名変更実行
        File(it).renameTo(File(newNames[i++]))
    }
}