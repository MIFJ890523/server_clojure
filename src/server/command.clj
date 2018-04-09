(ns server.command
  (:require [server.sUserInfo :as ui])
  (:import [com.jcraft.jsch JSch]
           [com.jcraft.jsch ChannelExec]
           [java.io InputStream])) 

(println "cargando command")



(defn command 
  "Conexión SSH"
  [data_user]
  (let [jsch (new JSch)]    
    (let [session (.getSession jsch "alex" "127.0.0.1" 2) user-pwd "xxxx"]      
      (.setUserInfo session (ui/get-user-info nil nil))
      (.setPassword session user-pwd)
      (.connect session)
      (let [channelExec (new ChannelExec)] (cast ChannelExec (.openChannel session ("exec")))
        (let [inMsj (new InputStream)] (cast InputStream (.getInputStream channelExec))))
      
      ())))



  ;(let [channelExec(ChannelExec (cast ChannelExec (.openChannel session ("exec"))))]))
 
  
(defn -main [& args]
  (command nil)) 

  ;ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
  ;InputStream inMsj = channelExec.getInputStream();
  ;InputStream inError = channelExec.getErrStream();
        
   ;     channelExec.setCommand(userData[4]);
    ;    channelExec.connect();
        
     ;   BufferedReader msj = new BufferedReader(new InputStreamReader(inMsj));
        ;BufferedReader error = new BufferedReader(new InputStreamReader(inError))))));
        
        ;String linea = null;
        ;int index = 0;
        
        ;while (((linea = msj.readLine()) != null) || ((linea = error.readLine()) != null)) {}
        ;System.out.println(++index + " : " + linea);
        
        
        ;channelExec.disconnect();
        ;session.disconnect()))));


  ;(response [{:name "alex"} {:name "Widget 2"}]))



