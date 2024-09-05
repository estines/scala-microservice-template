package io.nop.common.utils

object ParamsUtils {

}
//
//import scala.util.Try
//import scopt.OParser
//
//object ParamsUtils {
//  val builder = OParser.builder[(String, String, Boolean)]
//  val parser = {
//    import builder._
//    OParser.sequence(
//      programName("YourProgramName"),
//      head("Your Program Description", "1.0"),
//      opt[String]('i', "input")
//        .required()
//        .valueName("<file>")
//        .action((input, (i, o, v))
//    => (input, o, v)
//    )
//  .text("Path to input file")
//    ,
//    opt[String]('o', "output")
//      .valueName("<file>")
//      .action((output, (i, o, v))
//    => (i, output, v)
//    )
//  .text(s"Path to output file (default: $DefaultOutputFile)")
//    ,
//    opt[Unit]('v', "verbose")
//      .action((_, (i, o, v))
//    => (i, o, true)
//    )
//  .text("Enable verbose output")
//    )
//  }
//
//  def parseArgs(args: Array[String]): Try[(String, String, Boolean)] = {
//    OParser.parse(parser, args, ("", "output.txt", false)) match {
//      case Some(params) => Try(params) // params is now a tuple
//      case None => throw new IllegalArgumentException("Invalid arguments")
//    }
//  }
//}
