(ns muiapp.subs
  (:require
   [re-frame.core :as re-frame])
  )



(re-frame/reg-sub
 ::active-panel
 (fn [db]
   (:active-panel db)))



(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))