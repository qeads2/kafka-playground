package com.example.couponissue.domain.enums

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class StockHistoryTypeConverter: AttributeConverter<StockHistoryType, String> {
    override fun convertToDatabaseColumn(attribute: StockHistoryType?): String {
        return attribute?.name ?: ""
    }

    override fun convertToEntityAttribute(dbData: String?): StockHistoryType {
        return StockHistoryType.valueOf(dbData ?: "")
    }
}