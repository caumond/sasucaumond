(ns kotws.subs
  (:require
   [re-frame.core :as re-frame]
   [kotws.events :as events]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::active-panel
 (fn [db _]
   (:active-panel db)))

(re-frame/reg-sub
 ::re-pressed-example
 (fn [db _]
   (:re-pressed-example db)))

(re-frame/reg-sub
 ::language-changed
 (fn [db _]
   (:language db)))

(re-frame/reg-sub
 ::slide-change
 (fn [db _]
   (:slide-nb db)))

