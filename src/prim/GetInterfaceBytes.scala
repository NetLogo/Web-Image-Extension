package org.nlogo.extensions.webimage.prim

import
  java.awt.Component

import
  org.nlogo.{ api, awt, nvm, window },
    api.{ Argument, Context, DefaultReporter, Syntax },
      Syntax.WildcardType,
    awt.Images,
    nvm.ExtensionContext,
    window.GUIWorkspace

object GetInterfaceBytes extends DefaultReporter {
  override def getSyntax = Syntax.reporterSyntax(WildcardType)
  override def report(args: Array[Argument], context: Context): AnyRef = {
    // See the Web extension's `ExportInterface` code for justification for this (somewhat different) grossness --JAB (8/21/13)
    val component = context.asInstanceOf[ExtensionContext].workspace.asInstanceOf[GUIWorkspace].getWidgetContainer.asInstanceOf[Component]
    Images.paintToImage(component).toByteArray
  }
}


