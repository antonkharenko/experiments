<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <script type="text/javascript" src="js/dojo/dojo/dojo.js"></script>
    <script type="text/javascript">
        dojo.require("dojox.cometd");
        dojo.addOnLoad(function() {
            // Disconnect when the page unloads
            dojo.addOnUnload(function() {
               dojox.cometd.disconnect(true);
            });

            var cometURL = "cometd";
            dojox.cometd.init(cometURL);
        });
        function subscribe() {
        	dojox.cometd.subscribe("/*", console, "log");
        }
        function publish() {
        	dojox.cometd.publish('/service/hello', { name: 'World' })
        }
    </script>
</head>
<body>
    <input type="button" onclick="subscribe();" value="1. Subscribe" />
    <input type="button" onclick="publish();" value="2. Publish" />
</body>
</html>