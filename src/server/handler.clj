(ns server.handler
  (:require [server.command :as command]
            [compojure.core :refer [GET POST defroutes]] 
            [compojure.route :as route]
            [ring.util.response :refer [resource-response response]]
            [ring.middleware.json :as middleware] 
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defn view []
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (slurp "resources/public/index.html")})


(defroutes app-routes
  (GET  "/" [] (view)) 
  ;(POST  "/" [] (view)) 
  (GET  "/ssh/command/:data_user" [data_user] (command/command data_user)) 
  (route/resources "/") 
  (route/not-found "Not Found"))


(def app
  (-> app-routes
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)
      (wrap-defaults api-defaults))) 
