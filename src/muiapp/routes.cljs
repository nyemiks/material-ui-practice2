(ns muiapp.routes
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [re-frame.core :as re-frame]
            [muiapp.events :as events]
            )
  )

(def routes (atom 
             ["/" {"" :home
                  "about" :about
                   "tour" {["/" :id] :tour}
                  ; ":id" {[:id] :tour}
                  }
             ]
             )
  )

(def url-for (partial bidi/path-for @routes))


(defn parse-url [url]
  (bidi/match-route @routes url)
  )

(defn- dispatch-route [matched-route]
  (let [panel-name (keyword (str (name (:handler matched-route)) "-panel"))]
    (.info js/console "dispatch-route. panel name: " panel-name)
    (re-frame/dispatch [::events/set-active-panel panel-name])
    )
  
  )






(defn app-routes []
   (.info js/console " -- init app routes -- ")
  (pushy/start! (pushy/pushy dispatch-route parse-url))
  )