(ns muiapp.pages.home
  (:require ["@mui/material" :refer [Typography Container Grid]] 
              [muiapp.components.tourcard :refer [tourcard]]
           ;   [searchappbar :refer [SearchAppComponent]] 
              [muiapp.data :refer [cities]]
              [clojure.string :as str]
              )
  )


(defn home []
  [:div
  ;  [:> SearchAppComponent]

   [:> Container {
                   :sx {:marginY 5}
                   }
    (map (fn [city]
           [:<> {:key (:id city)}
            
              [:> Typography {
                            
                            :variant "h4"
                            :component "h2"
                            :marginTop 5
                            :marginBottom 3
                            }
              (str/join " " ["Top " (:name city) " tours"])
             ]

                 [:> Grid {
                           
                           :container true
                           :spacing 5
                          }
                     (map (fn [tour]
                           ^{:key (:id tour)} [tourcard tour]
                            ) 
                          (:tours city)                          
                          )
                 ]
            ]
           
            
          )
        cities)
    ]

   ]
  )