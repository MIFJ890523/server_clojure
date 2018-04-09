(defproject server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [compojure "1.6.0"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-json "0.4.0"] 
                 [ring/ring-defaults "0.3.1"]
                 ;;Paquetes JAR
                 [com.jcraft/jsch "0.1.54"]
                 [org.apache.commons/commons-vfs2 "2.2"]
                 [commons-logging/commons-logging "1.2"]]
                 
  :main server.command
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler server.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
