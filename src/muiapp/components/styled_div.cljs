(ns muiapp.components.styled-div
  (:require ["@mui/material" :refer [styled]])
  )


;(def mycomponent [])

(def mycomponent 
  (styled "div" {:color "red"
                 :backgroundColor "aliceblue"
                 :padding 8
                 :borderRadius 4}
          )
  )


(defn styled-div []
    [:> mycomponent]
  )