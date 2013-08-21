package org.nlogo.extensions.webimage.prim

import
  org.nlogo.{ api, nvm },
    api.{ Argument, Context, DefaultReporter, Syntax },
      Syntax.WildcardType,
    nvm.ExtensionContext

object GetViewBytes extends DefaultReporter {
  override def getSyntax = Syntax.reporterSyntax(WildcardType)
  override def report(args: Array[Argument], context: Context): AnyRef =
    context.asInstanceOf[ExtensionContext].workspace.exportView().toByteArray
}
