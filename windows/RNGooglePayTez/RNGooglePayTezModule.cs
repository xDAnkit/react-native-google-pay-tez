using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Google.Pay.Tez.RNGooglePayTez
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNGooglePayTezModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNGooglePayTezModule"/>.
        /// </summary>
        internal RNGooglePayTezModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNGooglePayTez";
            }
        }
    }
}
