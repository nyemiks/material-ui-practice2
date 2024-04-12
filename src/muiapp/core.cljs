(ns muiapp.core
    (:require 
     ["@mui/material" :refer [Typography Button Container Grid ThemeProvider]] ; [muiapp.components.theme2 :refer [new-theme]]
     [muiapp.components.theme :refer [button-theme button-theme-2]] ; loads custom theme at start up
     [muiapp.components.tourcard :refer [tourcard]]
     [reagent.dom :as d] ;["@mui/material" :as mui]
     [muiapp.pages.home :refer [home]]
     [muiapp.routes :refer [url-for app-routes]]
     [muiapp.views :refer [main-panel]]
     [re-frame.core :as re-frame]     
     [muiapp.events :as events]
     )
   
  )

;theme-props
;custom-theme
;; -------------------------
;; Views

(defn test-url-for [keyword]
  (url-for keyword)
  )

(defn text-button
 [label]
 [:> Button {:variant "text"} label])


(defn themed-button
  [label]
  [:> ThemeProvider  {:theme button-theme}
    [:> Button label]
   ]
  )


 (defn themed-button-2
  [label]
  [:> ThemeProvider  {:theme button-theme-2}
    [:> Button label]
   ]
  )
 

(comment 
  
  ; [search]
   
    ;[text-button  "click me"]
   
  ;  [themed-button "click me oh"]
   ; [themed-button-2 "click me again !!!"]


   [:> Container {
                   :sx {:marginY 5}
                   }
     [:> Grid {:container true
               :spacing 5
               }
       [tourcard]
       [tourcard]
       [tourcard]
       [tourcard]
      ]
     
    ]
  
  )




(defn home-page []
 ; [home]
   [main-panel]
  )

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (mount-root))
