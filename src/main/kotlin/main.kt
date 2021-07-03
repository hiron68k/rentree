
import java.io.File
import java.util.*

fun main(args: Array<String>) {
    fileList(".")
}

fun fileList(dirName: String) : Array<String> {
    // ファイル一覧を取得するディレクトリ
    val dir = File(dirName)

    //Fileクラスのlistメソッドを使用してファイル一覧を取得する
    val fileList = dir.list() ?: return arrayOf("")
    Arrays.sort(fileList)

    // 取得したファイル一覧を表示する
    fileList.forEach { fileName ->
        println(fileName)
    }
    return fileList
}