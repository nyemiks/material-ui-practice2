(ns muiapp.views
  (:require [re-frame.core :as re-frame]
            [muiapp.routes :as routes]
            [muiapp.subs :as subs]
          ;  [muiapp.events :as events]
             [searchappbar :refer [SearchAppComponent]] 
             [muiapp.pages.home :refer [home]]
             [muiapp.pages.tour :refer [tour]]
            )
  )


(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    (fn []
      [:div (str "Hello from " @name ". This is the Home Page.")
     ;  [:div [:a {:href } "go to About Page"]]
       ; (re-frame/dispatch [:set-active-panel panel-name])
       ; (re-frame/dispatch [::events/initialize-db])
       [:div [:a {:href (routes/url-for :about)} "go to About Page"]]
       ])))

(defn about-panel []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href (routes/url-for :home)} "go to Home Page"]]]))

;; --------------------
(defmulti panels identity)
(defmethod panels :home-panel [] [home])
(defmethod panels :about-panel [] [about-panel])
(defmethod panels :tour-panel [] [tour])
(defmethod panels :default [] [:div  "Default page"])



(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
   (.info js/console "active panel: " @active-panel)
    [:div 
        [:> SearchAppComponent]
         (panels @active-panel)       
       ]
    )
  )