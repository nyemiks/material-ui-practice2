(ns muiapp.components.tourcard
  (:require 
   [muiapp.components.theme :refer [custom-theme]]
   ["@mui/material" :refer [Paper Grid Typography Box Rating ThemeProvider]]
   ["@mui/icons-material" :refer [AccessTime]]
   ;["@mui/material" :refer [ThemeProvider]]
   [clojure.string :as str]
   )
  )


(defn tourcard [tour]   
    [:> Grid {
              :item true
              :xs 3
              }
     [:> ThemeProvider  {:theme custom-theme}
      [:> Paper {:elevation 3 } 
      [:img.img {:src (:image tour)}]

      [:> Box {:paddingX 1}
         [:> Typography {:variant "subtitle1" :component "h2"} (:name tour)]
           [:> Box {:sx {:display "flex" :alignItems "center"}}
            [:> AccessTime {:sx {:width 12.5}}]
            [:> Typography {
                            :variant "body2"
                            :component "p"
                            :marginLeft 0.5
                            }
            (str/join " " [(:duration tour) " hours"]) 
             ]
            ]
          [:> Box {:sx {:display "flex" :alignItems "center"}
                   :marginTop 3
                   } 
             [:> Rating {
                         :name "read-only" 
                         :value (:rating tour) 
                         :precision 0.5 
                         :readOnly true
                         :size "small"
                         }
              ]
             [:> Typography {
                            :variant "body2"
                            :component "p"
                            :marginLeft 0.5
                            }
             (:rating tour)
             ]
             [:> Typography {
                            :variant "body3"
                            :component "p"
                            :marginLeft 1.5
                            }
             (str/join "" ["(" (:numberOfReviews tour) " reviews)"])
             ]
           ]
           [:> Box
              [:> Typography {
                              :variant "h6"
                              :component "h3"
                              :marginTop 0
                              }
                  (str/join "" ["From C $" (:price tour)])
               ]
            ]
       ]
      
      ]]
      
       
     
     ]
  )