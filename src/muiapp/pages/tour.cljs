(ns muiapp.pages.tour
  (:require ["@mui/material" :refer [Typography Container Box Paper BottomNavigation]] 
            [muiapp.components.imagecollage :refer [image-collage]]
            [searchappbar :refer [CustomAccordion]] 
            [muiapp.components.modal :refer [basic-modal]]
            )
  
  )


(defn tour []
  [:> Container {:sx {:width 900}} 
   [:> Typography {:variant "h3" :component "h1" :marginTop 3} "Explore the World in Vegas"]
   
   [:> Box {:marginTop 3 :sx {:display "flex"}
            }
    [:img {:src "https://media.timeout.com/images/105124791/750/422/image.jpg" :height 325}]
    
    [image-collage]
    ]
     [:> Box
        [:> Typography {:variant "h6" :component "h4" :marginTop 3} "About this ticket"]
         [:> Typography {:variant "paragraph" :component "p" :marginTop 3}
          "Lorem ipsum dolor sit amet consectetur adipisicing elit. 
        At quasi, quo aut nobis quae recusandae molestias reiciendis eaque rem quaerat tenetur aperiam ea ex, ut distinctio vero dolorum ab?
         Sed."
          ]
 
      ]
      [:> Box {:marginBottom 10}
        [:> Typography {:variant "h6" :component "h4" :marginTop 3} 
         "Frequently asked questions."
         ]
         [:> CustomAccordion]
      ]
       [:> Paper {:sx {:position "fixed"
                       :bottom 0
                       :left 0
                       :right 0
                       }
                  }
        [:> BottomNavigation 
         [basic-modal]
         ]
        ]
   ]
  )