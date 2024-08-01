package com.example.kafkaplayground.service

import com.example.kafkaplayground.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository,
) {
    fun decreaseStock(itemId: Int) {
        val item = itemRepository.findById(itemId).get()
        item.decreaseStock()
        itemRepository.save(item)
    }
}
