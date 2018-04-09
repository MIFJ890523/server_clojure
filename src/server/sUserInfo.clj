(ns server.sUserInfo
  (:import [com.jcraft.jsch UserInfo]
           [java.lang Runnable]))


;(defn get-user-info-resp [password phassPhrase]
;  (proxy [UserInfo]
;  (getPassphrase []
;  phassPhrase
;  (getPassword []
;  password
;  (promptPassphrase [arg]
;  true
;  (promptPassword [arg]
;  false
;  (promptYesNo [arg]
;  true
;  (showMessage [arg]
;  (println "SUserInfo.showMessage()"))

;USA MEJOR "reify"

(defn get-user-info [password passPhrase]
  (proxy [UserInfo] []
    (getPassphrase []
      (passPhrase))
    (getPassword []
      (password))
    (promptPassword [arg0]
      (true))
    (promptPassphrase [arg0]
      (false))
    (promptYesNo [arg0]
      (true))
    (showMessage [arg0]
      ((println "SUserInfo.showMessage()"))))) 



