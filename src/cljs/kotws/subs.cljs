(ns kotws.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub ::name (fn [db] (:name db)))

(re-frame/reg-sub ::active-panel (fn [db _] (:active-panel db)))

(re-frame/reg-sub ::language (fn [db _] (:language db)))

(re-frame/reg-sub ::selected-items (fn [db _] (:selected-items db)))

(re-frame/reg-sub ::show-left-panel (fn [db _] (:show-left-panel db)))
