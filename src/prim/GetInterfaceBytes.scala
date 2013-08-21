package org.nlogo.extensions.webimage.prim

import
  org.nlogo.{ api, app, awt },
    api.{ Argument, Context, DefaultReporter, Syntax },
      Syntax.WildcardType,
    app.App,
    awt.Images

object GetInterfaceBytes extends DefaultReporter {
  override def getSyntax = Syntax.reporterSyntax(WildcardType)
  override def report(args: Array[Argument], context: Context): AnyRef = {
    // See the Web extension's `ExportInterface` code for justification for this grossness --JAB (8/21/13)
    val component = App.app.tabs.interfaceTab.getInterfacePanel
    Images.paintToImage(component).toByteArray
  }
}


