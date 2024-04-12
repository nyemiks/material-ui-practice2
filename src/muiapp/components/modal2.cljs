(ns muiapp.components.modal2
  (:require [reagent.core :as r]
           ; [reagent.dom :as rdom]            
            ["@mui/material" :refer [Modal Typography Box Button]] 
            )
  )

(def style
  {:position "absolute"
   :top "50%"
   :left "50%"
   :transform "translate(-50%, -50%)"
   :width 400
   :bgcolor "background.paper"
   :border "2px solid #000"
   :box-shadow 24
   :p 4})

(defn basic-modal []
  (let [[open? set-open!] (r/useState false)
        handle-open #(set-open! true)
        handle-close #(set-open! false)]
    [:div
     [Button {:on-click handle-open} "Open modal"]
     [Modal {:open open?
             :on-close handle-close
             :aria-labelledby "modal-modal-title"
             :aria-describedby "modal-modal-description"}
      [Box {:sx style}
       [Typography {:id "modal-modal-title"
                    :variant "h6"
                    :component "h2"} "Text in a modal"]
       [Typography {:id "modal-modal-description"
                    :sx {:mt 2}} "Duis mollis, est non commodo luctus, nisi erat porttitor ligula."]]]]))

