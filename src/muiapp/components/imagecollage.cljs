(ns muiapp.components.imagecollage
  (:require ["@mui/material" :refer [ImageList ImageListItem]]
           
            )
  )


(def item-data 
  [{:img "https://images.unsplash.com/photo-1551963831-b3b1ca40c98e",
  :title "Breakfast",
  :rows 2,
  :cols 2}
 {:img "https://images.unsplash.com/photo-1551782450-a2132b4ba21d",
  :title "Burger"}
 {:img "https://images.unsplash.com/photo-1522770179533-24471fcdba45",
  :title "Camera"}
 {:img "https://images.unsplash.com/photo-1444418776041-9c7e33cc5a9c",
  :title "Coffee",
  :cols 2}
 {:img "https://images.unsplash.com/photo-1533827432537-70133748f5c8",
  :title "Hats",
  :cols 2}
 {:img "https://images.unsplash.com/photo-1558642452-9d2a7deb7f62",
  :title "Honey",
  :author "@arwinneil",
  :rows 2,
  :cols 2}
 {:img "https://images.unsplash.com/photo-1516802273409-68526ee1bdd6",
  :title "Basketball"}
 {:img "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
  :title "Fern"}
 {:img "https://images.unsplash.com/photo-1597645587822-e99fa5d45d25",
  :title "Mushrooms",
  :rows 2,
  :cols 2}
 {:img "https://images.unsplash.com/photo-1567306301408-9b74779a11af",
  :title "Tomato basil"}
 {:img "https://images.unsplash.com/photo-1471357674240-e1a485acb3e1",
  :title "Sea star"}
 {:img "https://images.unsplash.com/photo-1589118949245-7d38baf380d6",
  :title "Bike", 
  :cols 2}]

  )


(defn srcset
  [image size & {:keys [rows cols] :or {rows 1 cols 1}}]
  {:src (str image "?w=" (* size cols) "&h=" (* size rows) "&fit=crop&auto=format")
   :srcSet (str image "?w=" (* size cols) "&h=" (* size rows) "&fit=crop&auto=format&dpr=2 2x")})




(defn image-collage []
  [:> ImageList {:sx {:width 300 :height 325 :margin-left 1}
                 :variant "quilted"
                 :cols 4
                 :row-height 121}
   (for [item item-data]
     ^{:key (:img item)}
     [:> ImageListItem {:cols (or (:cols item) 1)
                        :rows (or (:rows item) 1)}
      [:img (merge (srcset (:img item) 121 (:rows item) (:cols item))
                   {
                    :alt (:title item)
                    :loading "lazy"
                    }
       )
       ]
      
     ]
     )
  ]
)