(ns muiapp.events
(:require [re-frame.core :as re-frame]
          [muiapp.db :as db]
          )     
  )



(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))



(comment 
  
  (re-frame/reg-event-db
 ::navigate
 (fn [db [_ panel]]
   (assoc db :active-panel panel)
   )
 )
  
  )



(re-frame/reg-event-fx
  ::navigate
  (fn [_ handler]
    (.info js/console " -- navigate fx triggered handler-- ")
    (.info js/console "handler: " handler)
    {:navigate handler}
    )
 )


(re-frame/reg-event-fx
 ::set-active-panel
 (fn [{:keys [db]} [_ active-panel]]
   {:db (assoc db :active-panel active-panel)}
            )
 )
